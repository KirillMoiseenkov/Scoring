package com.example.demo.utils.factory;

import com.example.demo.utils.DataType;
import com.example.demo.utils.ScoringXMLTag;
import com.example.demo.utils.factory.model.ScoringXMLTagCommonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ScoringXMLTagCreatorCommon extends ScoringXMLTagCreator {

  @Override
  public ScoringXMLTagCommonEntity createScoringTagEntity(ScoringXMLTag nameTag, String value) {
    return getScoringXMLTagCommonEntity(nameTag.getDataType(), nameTag.getNode(), value);
  }

  @Override
  public ScoringXMLTagCommonEntity createScoringTagEntity(DataType dataType, String nameTagStr, String value) {
    return getScoringXMLTagCommonEntity(dataType, nameTagStr, value);
  }

  @Override
  public ScoringXMLTagCommonEntity createScoringArrayTagEntity(ScoringXMLTag nameTag, List<String> listData) {
    replenishment(nameTag, listData);
    ScoringXMLTagCommonEntity xmlTagScoring = new ScoringXMLTagCommonEntity(nameTag.getNode());
    xmlTagScoring.setDataType(nameTag.getDataType());
    create(nameTag, listData, xmlTagScoring);
    return xmlTagScoring;
  }

  @Override
  public ScoringXMLTagCommonEntity createScoringArrayTagEntity(ScoringXMLTag nameTag, String nameTagStr, List<String> listData) {
    replenishment(nameTag, listData);
    ScoringXMLTagCommonEntity xmlTagScoring = new ScoringXMLTagCommonEntity(nameTagStr);
    xmlTagScoring.setDataType(nameTag.getDataType());
    create(nameTag, listData, xmlTagScoring);
    return xmlTagScoring;
  }

  private ScoringXMLTagCommonEntity getScoringXMLTagCommonEntity(DataType dataType, String nameTagStr, String value) {
    ScoringXMLTagCommonEntity xmlTagScoring;
    switch (dataType) {
      case date:
        xmlTagScoring = super.createDate(nameTagStr, value);
        break;
      case text:
        xmlTagScoring = super.createText(nameTagStr, value);
        break;
      case numeric:
        xmlTagScoring = super.createNumeric(nameTagStr, value);
        break;
      case no_array:
        xmlTagScoring = super.createNotArray(nameTagStr, value);
        break;
      default:
        log.error("Unknown nameTag {} dataType {} ", nameTagStr, dataType);
        throw new IllegalArgumentException("Unknown type  " + dataType);
    }
    return xmlTagScoring;
  }

  private void create(ScoringXMLTag nameTag, List<String> listData, ScoringXMLTagCommonEntity xmlTagScoring) {
    switch (nameTag.getDataType()) {
      case date:
        xmlTagScoring.setScoringCommonList(tagDateScoringList(nameTag, listData, nameTag.getCycle()));
        break;
      case text:
        xmlTagScoring.setScoringCommonList(tagTextScoringList(nameTag, listData, nameTag.getCycle()));
        break;
      case numeric:
        xmlTagScoring.setScoringCommonList(tagNumericScoringList(nameTag, listData, nameTag.getCycle()));
        break;
      default:
        log.error("Unknown nameTag {} dataType {} ", nameTag.getNode(), nameTag.getDataType());
        throw new IllegalArgumentException("Unknown type  " + nameTag.getDataType());
    }
  }

  private List<ScoringXMLTagCommonEntity> tagDateScoringList(ScoringXMLTag nameTag, List<String> listData, Integer cycle) {
    List<ScoringXMLTagCommonEntity> result = new ArrayList<>();
    int count = 1;
    for (int i = 0; i < cycle; i++) {
      result.add(super.createDate(nameTag.getArrayNameTag().toString() + count, listData.get(i)));
      count++;
    }
    return result;
  }

  private List<ScoringXMLTagCommonEntity> tagTextScoringList(ScoringXMLTag nameTag, List<String> listData, Integer cycle) {
    List<ScoringXMLTagCommonEntity> result = new ArrayList<>();
    int count = 1;
    for (int i = 0; i < cycle; i++) {
      result.add(super.createText(nameTag.getArrayNameTag().toString() + count, listData.get(i)));
      count++;
    }
    return result;
  }

  private List<ScoringXMLTagCommonEntity> tagNumericScoringList(ScoringXMLTag nameTag, List<String> listData, Integer cycle) {
    List<ScoringXMLTagCommonEntity> result = new ArrayList<>();
    int count = 1;
    for (int i = 0; i < cycle; i++) {
      result.add(super.createNumeric(nameTag.getArrayNameTag().toString() + count, listData.get(i)));
      count++;
    }
    return result;
  }

  /**
   * Дозаполняет массив "заглушками"
   *
   * @param listData дозаполняемый массив
   */
  private void replenishment(ScoringXMLTag nameTag, List<String> listData) {
    List<String> list = new ArrayList<>();
    if (listData.size() != nameTag.getCycle()) {
      int count = nameTag.getCycle() - listData.size();
      for (int i = 0; i < count; i++) {
        list.add("");
      }
    }
    listData.addAll(list);
  }
}
