package com.example.demo.utils;

import com.example.demo.utils.factory.model.ScoringXMLTagCommonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import static com.example.demo.utils.DataType.*;
import static com.example.demo.utils.ScoringXMLTag.LAYOUT;

@Component
@Slf4j
public class ScoringXMLUtilsImpl implements ScoringXMLUtils {

  private static final String DATA_TYPE = "data_type";

  private static final String DATE_FORMAT = "date_format";

  private static final String VALUE = "value";

  private static final String ARRAY = "array";

  private static final String MESSAGE_ERROR = "Error create xml file scoring NAME_TAG {} XML {} ";

  @Override
  public String createScoringTag(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException {
    return createTag(scoringCommon, source);
  }

  @Override
  public String createScoringArrayTag(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException {
    return createArray(scoringCommon, source);
  }

  @Override
  public String createScoringArrayTagInTag(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException {
    return createScoringArrayTagInTag(scoringCommon, source);
  }

  @Override
  public String changeScoringArrayTagValue(String source, ScoringXMLTagCommonEntity scoringCommon, Long index) throws IOException, XMLStreamException {
    return changeScoringArrayTagValue(scoringCommon, source, index);
  }

  @Override
  public String changeScoringTagValue(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException {
    return changeScoringTagValue(scoringCommon, source);
  }

  private String changeScoringTagValue(ScoringXMLTagCommonEntity scoringCommon, String source) throws XMLStreamException, IOException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
    XMLEventFactory ef = XMLEventFactory.newInstance();
    XMLEventReader xmlEventReader = null;
    XMLEventWriter writer = null;
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8.name()));
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
      writer = xmlOutputFactory.createXMLEventWriter(outputStream);
      while (xmlEventReader.hasNext()) {
        XMLEvent event = xmlEventReader.nextEvent();
        if (event.isStartElement()) {
          StartElement element = event.asStartElement();
          if (element.getName().getLocalPart().equals(scoringCommon.getNameTag())) {
            setNumericAndTextValueFromString(xmlEventReader, writer, event, ef, scoringCommon.getValue());
          } else {
            writer.add(event);
          }
        } else {
          try {
            writer.add(event);
          } catch (XMLStreamException e) {
            log.error(MESSAGE_ERROR, scoringCommon.getNameTag());
          }
        }
      }
      writer.flush();
      return outputStream.toString(StandardCharsets.UTF_8.name());
    } finally {
      if (Objects.nonNull(xmlEventReader)) {
        xmlEventReader.close();
      }
      if (Objects.nonNull(writer)) {
        writer.close();
      }
    }
  }

  private String createTag(ScoringXMLTagCommonEntity scoringCommon, String source) throws IOException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
    XMLEventFactory ef = XMLEventFactory.newInstance();
    XMLEventReader xmlEventReader = null;
    XMLEventWriter writer = null;
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8.name()));
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
      writer = xmlOutputFactory.createXMLEventWriter(outputStream);
      while (xmlEventReader.hasNext()) {
        XMLEvent event = xmlEventReader.nextEvent();
        if (event.isStartElement()) {
          StartElement element = event.asStartElement();
          if (element.getName().getLocalPart().equals(LAYOUT.toString())) {
            writer.add(event);
            writer.add(ef.createCharacters("\n        "));

            XMLEvent eventProm = ef.createStartElement(new QName(scoringCommon.getNameTag()), null, null);
            writer.add(eventProm);
            final DataType dataType = scoringCommon.getDataType();
            createNewTag(DATA_TYPE, scoringCommon.getDataType().toString(), writer, ef);
            createNewTag(VALUE, scoringCommon.getValue(), writer, ef);
            if (dataType == date) {
              createNewTag(DATE_FORMAT, scoringCommon.getDateFormat(), writer, ef);
            }
            writer.add(ef.createCharacters("\n        "));
            eventProm = ef.createEndElement(new QName(scoringCommon.getNameTag()), null);
            writer.add(eventProm);
          } else {
            writer.add(event);
          }
        } else {
          try {
            writer.add(event);
          } catch (XMLStreamException e) {
            log.error(MESSAGE_ERROR, scoringCommon.getNameTag());
          }
        }
      }
      writer.flush();
      return outputStream.toString(StandardCharsets.UTF_8.name());
    } finally {
      if (Objects.nonNull(xmlEventReader)) {
        xmlEventReader.close();
      }
      if (Objects.nonNull(writer)) {
        writer.close();
      }
    }
  }

  private String createArray(ScoringXMLTagCommonEntity scoringCommon, String source) throws IOException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
    XMLEventFactory ef = XMLEventFactory.newInstance();
    XMLEventReader xmlEventReader = null;
    XMLEventWriter writer = null;
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8.name()));
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
      writer = xmlOutputFactory.createXMLEventWriter(outputStream);
      while (xmlEventReader.hasNext()) {
        XMLEvent event = xmlEventReader.nextEvent();
        if (event.isStartElement()) {
          StartElement element = event.asStartElement();
          if (element.getName().getLocalPart().equals(LAYOUT.toString())) {
            writer.add(event);
            writer.add(ef.createCharacters("\n        "));

            XMLEvent eventProm = ef.createStartElement(new QName(scoringCommon.getNameTag()), null, null);
            writer.add(eventProm);
            if (scoringCommon.getDataType() != no_array) {
              createNewTag(DATA_TYPE, ARRAY, writer, ef);
            }
            final DataType dataType = scoringCommon.getDataType();
            final List<ScoringXMLTagCommonEntity> commonList = scoringCommon.getScoringCommonList();
            for (int i = 0; i < commonList.size(); i++) {
              ScoringXMLTagCommonEntity entity = commonList.get(i);
              writer.add(ef.createCharacters("\n        "));
              eventProm = ef.createStartElement(new QName(commonList.get(i).getNameTag()), null, null);
              writer.add(eventProm);
              createNewTag(DATA_TYPE, entity.getDataType().toString(), writer, ef);
              createNewTag(VALUE, entity.getValue(), writer, ef);
              if (dataType == date) {
                createNewTag(DATE_FORMAT, entity.getDateFormat(), writer, ef);
              }
              writer.add(ef.createCharacters("\n        "));
              eventProm = ef.createEndElement(new QName(commonList.get(i).getNameTag()), null);
              writer.add(eventProm);
            }
            writer.add(ef.createCharacters("\n        "));
            eventProm = ef.createEndElement(new QName(scoringCommon.getNameTag()), null);
            writer.add(eventProm);
          } else {
            writer.add(event);
          }
        } else {
          try {
            writer.add(event);
          } catch (XMLStreamException e) {
            log.error(MESSAGE_ERROR, scoringCommon.getNameTag());
          }
        }
      }
      writer.flush();
      return outputStream.toString(StandardCharsets.UTF_8.name());
    } finally {
      if (Objects.nonNull(xmlEventReader)) {
        xmlEventReader.close();
      }
      if (Objects.nonNull(writer)) {
        writer.close();
      }
    }
  }

  private String createScoringArrayTagInTag(ScoringXMLTagCommonEntity scoringCommon, String source) throws IOException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
    XMLEventFactory ef = XMLEventFactory.newInstance();
    XMLEventReader xmlEventReader = null;
    XMLEventWriter writer = null;
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8.name()));
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
      writer = xmlOutputFactory.createXMLEventWriter(outputStream);
      while (xmlEventReader.hasNext()) {
        XMLEvent event = xmlEventReader.nextEvent();
        if (event.isStartElement()) {
          StartElement element = event.asStartElement();
          if (element.getName().getLocalPart().equals(scoringCommon.getNameTag())) {
            writer.add(event);
            writer.add(ef.createCharacters("\n        "));

            final List<ScoringXMLTagCommonEntity> commonList = scoringCommon.getScoringCommonList();
            for (int i = 0; i < commonList.size(); i++) {
              ScoringXMLTagCommonEntity entity = commonList.get(i);
              writer.add(ef.createCharacters("\n        "));
              XMLEvent eventProm = ef.createStartElement(new QName(commonList.get(i).getNameTag()), null, null);
              writer.add(eventProm);
              createNewTag(DATA_TYPE, entity.getDataType().toString(), writer, ef);
              createNewTag(VALUE, entity.getValue(), writer, ef);
              writer.add(ef.createCharacters("\n        "));
              eventProm = ef.createEndElement(new QName(commonList.get(i).getNameTag()), null);
              writer.add(eventProm);
            }
          } else {
            writer.add(event);
          }
        } else {
          try {
            writer.add(event);
          } catch (XMLStreamException e) {
            log.error(MESSAGE_ERROR, scoringCommon.getNameTag());
          }
        }
      }
      writer.flush();
      return outputStream.toString(StandardCharsets.UTF_8.name());
    } finally {
      if (Objects.nonNull(xmlEventReader)) {
        xmlEventReader.close();
      }
      if (Objects.nonNull(writer)) {
        writer.close();
      }
    }
  }

  private String changeScoringArrayTagValue(ScoringXMLTagCommonEntity scoringCommon, String source, Long index) throws IOException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
    XMLEventFactory ef = XMLEventFactory.newInstance();
    StartElement element = null;
    boolean indexTrig = false;
    XMLEventReader xmlEventReader = null;
    XMLEventWriter writer = null;
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8.name()));
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
      writer = xmlOutputFactory.createXMLEventWriter(outputStream);
      while (xmlEventReader.hasNext()) {
        XMLEvent event = xmlEventReader.nextEvent();
        if (event.isStartElement()) {
          element = event.asStartElement();
          if (element.getName().getLocalPart().equalsIgnoreCase(scoringCommon.getNameTag())) {
            indexTrig = true;
            writer.add(event);
          } else {
            writer.add(event);
          }
        } else {
          try {
            if (indexTrig && element.getName().getLocalPart().equals("I" + index)) {
              indexTrig = false;
              if (scoringCommon.getDataType() == date) {
                setFcbpcalendarValueFromDate(xmlEventReader, writer, event, ef, scoringCommon.getValue());
              } else {
                setFcbpcalendarValueFromString(xmlEventReader, writer, event, ef, scoringCommon.getValue());
              }
            }
            writer.add(event);
          } catch (XMLStreamException e) {
            log.error(MESSAGE_ERROR, scoringCommon.getNameTag());
          }
        }
      }
      writer.flush();
      return outputStream.toString(StandardCharsets.UTF_8.name());
    } finally {
      if (Objects.nonNull(xmlEventReader)) {
        xmlEventReader.close();
      }
      if (Objects.nonNull(writer)) {
        writer.close();
      }
    }
  }

  private void setFcbpcalendarValueFromString(XMLEventReader xmlEventReader, XMLEventWriter writer, XMLEvent xmlEvent, XMLEventFactory ef, String value) throws XMLStreamException {
    writer.add(xmlEvent);
    for (int i = 0; i < 5; i++) {
      xmlEvent = xmlEventReader.nextEvent();
      writer.add(xmlEvent);
    }
    xmlEvent = xmlEventReader.nextEvent();
    if (xmlEvent.isCharacters()) {
      XMLEvent xmlEvent1 = ef.createCharacters(value);
      writer.add(xmlEvent1);
    }
    xmlEvent = xmlEventReader.nextEvent();
    writer.add(xmlEvent);
  }

  private void setNumericAndTextValueFromString(XMLEventReader xmlEventReader, XMLEventWriter writer, XMLEvent xmlEvent, XMLEventFactory ef, String value) throws XMLStreamException {
    for (int i = 0; i < 6; i++) {
      writer.add(xmlEvent);
      xmlEvent = xmlEventReader.nextEvent();
    }
    writer.add(xmlEvent);
    xmlEvent = xmlEventReader.nextEvent();
    if (xmlEvent.isCharacters() && value != null && !value.equals("") && !value.equals("-")) {
      XMLEvent xmlEvent1 = ef.createCharacters(value);
      writer.add(xmlEvent1);
    }
  }

  private void createNewTag(String nameTag, String date, XMLEventWriter writer, XMLEventFactory ef) throws XMLStreamException {
    XMLEvent eventProm;
    writer.add(ef.createCharacters("\n        "));
    eventProm = ef.createStartElement(new QName(nameTag), null, null);
    writer.add(eventProm);
    writer.add(ef.createCharacters(date));
    eventProm = ef.createEndElement(new QName(nameTag), null);
    writer.add(eventProm);
  }

  private void setFcbpcalendarValueFromDate(XMLEventReader xmlEventReader, XMLEventWriter writer, XMLEvent xmlEvent, XMLEventFactory ef, String value) throws XMLStreamException {
    writer.add(xmlEvent);
    for (int i = 0; i < 5; i++) {
      xmlEvent = xmlEventReader.nextEvent();
      writer.add(xmlEvent);
    }
    xmlEvent = xmlEventReader.nextEvent();
    if (xmlEvent.isCharacters()) {
      XMLEvent xmlEvent1 = ef.createCharacters(value);
      writer.add(xmlEvent1);
    }
    for (int i = 0; i < 3; i++) {
      xmlEvent = xmlEventReader.nextEvent();
      writer.add(xmlEvent);
    }
    xmlEvent = xmlEventReader.nextEvent();
    if (xmlEvent.isCharacters()) {
      XMLEvent xmlEvent1 = ef.createCharacters("dd.MM.yyyy");
      writer.add(xmlEvent1);
    }
    xmlEvent = xmlEventReader.nextEvent();
    writer.add(xmlEvent);
  }
}
