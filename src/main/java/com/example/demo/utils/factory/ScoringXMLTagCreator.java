package com.example.demo.utils.factory;


import com.example.demo.utils.DataType;
import com.example.demo.utils.ScoringXMLTag;
import com.example.demo.utils.factory.model.ScoringXMLTagCommonEntity;

import java.util.List;
import java.util.Objects;

import static com.example.demo.utils.DataType.*;
import static com.example.demo.utils.ScoringXMLTag.LAYOUT;


public abstract class ScoringXMLTagCreator {

  ScoringXMLTagCommonEntity createNumeric(String nameTag, String value) {
    if (Objects.nonNull(value) && value.equals("")) {
      return new ScoringXMLTagCommonEntity(nameTag, numeric,"-99");
    }
    return new ScoringXMLTagCommonEntity(nameTag, numeric, value);
  }

  ScoringXMLTagCommonEntity createText(String nameTag, String value) {
    if (Objects.nonNull(value) && value.equals("")) {
      return new ScoringXMLTagCommonEntity(nameTag, text, "\"-99\"");
    }
    return new ScoringXMLTagCommonEntity(nameTag, text, value);
  }

  ScoringXMLTagCommonEntity createDate(String nameTag, String value) {
    if (Objects.nonNull(value) && value.equals("")) {
      return new ScoringXMLTagCommonEntity(nameTag, date, "1900-01-01", "yyyy-MM-dd");
    }
    return new ScoringXMLTagCommonEntity(nameTag, date, value,"yyyy-MM-dd");
  }

  ScoringXMLTagCommonEntity createNotArray(String nameTag, String value) {
    if (Objects.nonNull(value) && value.equals("")) {
      return new ScoringXMLTagCommonEntity(nameTag, no_array, "", "");
    }
    return new ScoringXMLTagCommonEntity(nameTag, no_array, value,"");
  }

  /**
   * Создает один тэг
   * @param nameTag имя тэга
   * @param value значение для тэга <value>P01</value> если его нет, то вставляется дефолтное
   * @return ScoringXMLTagCommonEntity
   */
  public abstract ScoringXMLTagCommonEntity createScoringTagEntity(ScoringXMLTag nameTag, String value);

  /**
   * Создает один тэг
   * @param nameTagStr имя тэга
   * @param value значение для тэга <value>P01</value> если его нет, то вставляется дефолтное
   * @return ScoringXMLTagCommonEntity
   */
  public abstract ScoringXMLTagCommonEntity createScoringTagEntity(DataType dataType, String nameTagStr, String value);

  /**
   * Создает массив тэгов
   * @param nameTag имя массива
   * @param listData значение для тэга <value>P01</value> если его нет, то вставляется дефолтное
   * @return ScoringXMLTagCommonEntity
   * Пример:
   *          <SortedReasonCodeTable>
   *                 <data_type>array</data_type>
   *                 <I1>
   *                     <data_type>text</data_type>
   *                     <value>P01</value>
   *                 </I1>
   *                 <I2>
   *                     <data_type>text</data_type>
   *                     <value>A202</value>
   *                 </I2>
   */
  public abstract ScoringXMLTagCommonEntity createScoringArrayTagEntity(ScoringXMLTag nameTag, List<String> listData);

  /**
   * Метод используется для тех случаев когда название массива изменяется незначительно.
   * Создает массив тэгов
   * @param nameTagStr имя массива
   * @param listData значение для тэга <value>P01</value> если его нет, то вставляется дефолтное
   * @return ScoringXMLTagCommonEntity
   *  Пример:
   *          <Fcbpcalendar01date>
   *                 <data_type>array</data_type>
   *                 <I1>
   *                     <data_type>text</data_type>
   *                     <value>P01</value>
   *                 </I1>
   *                 <I2>
   *                     <data_type>text</data_type>
   *                     <value>A202</value>
   *                 </I2>
   *          </Fcbpcalendar01date>
   *          <Fcbpcalendar02date>
   *            <data_type>array</data_type>
   *                  <I1>
   *                    <data_type>text</data_type>
   *                    <value>P01</value>
   *                  </I1>
   *          <Fcbpcalendar02date>
   *
   * Где:
   *    Fcbpcalendar01date = nameTagStr
   *    I1                 = берется из nameTag
   */
  public abstract ScoringXMLTagCommonEntity createScoringArrayTagEntity(ScoringXMLTag nameTag, String nameTagStr, List<String> listData);
}
