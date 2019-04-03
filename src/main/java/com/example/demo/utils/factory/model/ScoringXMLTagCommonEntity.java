package com.example.demo.utils.factory.model;


import com.example.demo.utils.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ScoringXMLTagCommonEntity {

  private String nameTag;

  private DataType dataType;

  private String value;

  private String dateFormat;

  List<ScoringXMLTagCommonEntity> scoringCommonList = new ArrayList<>();

  public ScoringXMLTagCommonEntity(String nameTag) {
    this.nameTag = nameTag;
  }

  public ScoringXMLTagCommonEntity(String nameTag, DataType dataType, String value) {
    this.nameTag = nameTag;
    this.dataType = dataType;
    this.value = value;
  }

  public ScoringXMLTagCommonEntity(String nameTag, DataType dataType, String value, String dateFormat) {
    this.nameTag = nameTag;
    this.dataType = dataType;
    this.value = value;
    this.dateFormat = dateFormat;
  }
}
