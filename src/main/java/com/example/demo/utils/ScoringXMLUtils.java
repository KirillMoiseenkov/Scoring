package com.example.demo.utils;


import com.example.demo.utils.factory.model.ScoringXMLTagCommonEntity;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Сервис предназначен для добавление или изменения тегов в xml файле
 */
public interface ScoringXMLUtils {

  /**
   * Создает тэг в xml файле
   *
   * @param source xml файл
   * @scoringCommon объект описывает новый тэг
   * @return изменный xml
   * @throws IOException
   * @throws XMLStreamException
   */
  String createScoringTag(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException;

  /**
   * Создает массив тэгов в xml файле
   *
   * @param source xml файл
   * @scoringCommon объект описывает массив новых тэгов
   * @return изменный xml
   * @throws IOException
   * @throws XMLStreamException
   */
  String createScoringArrayTag(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException;

  /**
   * Изменяет значение value в массиве
   *
   * @param source       xml файл
   * @param scoringCommon имя изменяемого массива
   * @param index        индекс изменяемого массива
   * @return изменный xml
   * @throws IOException
   * @throws XMLStreamException
   */
  String changeScoringArrayTagValue(String source, ScoringXMLTagCommonEntity scoringCommon, Long index) throws IOException, XMLStreamException;

  /**
   * Изменяет значение value в xml файле для конкретного тэга
   *
   * @param source xml файл
   * @param scoringCommon   объект описывает изменяемый тэг
   * @return изменный xml
   * @throws IOException
   * @throws XMLStreamException
   */
  String changeScoringTagValue(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException;

  String createScoringArrayTagInTag(String source, ScoringXMLTagCommonEntity scoringCommon) throws IOException, XMLStreamException;
}
