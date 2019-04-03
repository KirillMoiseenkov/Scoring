package com.example.demo.utils;

import static com.example.demo.utils.DataType.*;
import static  com.example.demo.utils.ArrayNameTagScoring.*;

/**
 *  Описывает тэги в xml файле для 2-ого этапа скоринга.
 *  Пример добавление нового тэга:
 *  'FCB_SURNAME("Fcbsurname", text),' 'text' тип для '<data_type>text</data_type>' (с учетом регистра) 'Fcbsurname' будет название тэга.
 *  FCB_REPORT_TYPE("Fcbreporttype", numeric)          для 'numeric'
 *  FCB_DATE_OF_BIRTH_DATE("Fcbdateofbirth", date)     для 'date'
 *
 *  Для массивов:
 *  'FCB_DOC_DATE_OF_REGISTRATION("Fcbdocdateofregistration", date, I, 30)'
 *       Fcbdocdateofregistration - название массива
 *       date                     - тип массива '<data_type>date</data_type>'
 *       I                        - имя для индекса массива
 *       30                       - кол-во индексов
 * Пример:
 *<Fcbdocdateofregistration>
 *             <data_type>array</data_type>
 *             <I1>
 *                 <data_type>date</data_type>
 *                 <value>01.01.1915</value>
 *                 <date_format>dd.MM.yyyy</date_format>
 *             </I1>
 *             <I2>
 *                 <data_type>date</data_type>
 *                 <value>11.04.2006</value>
 *                 <date_format>dd.MM.yyyy</date_format>
 *             </I2>
 */
public enum ScoringXMLTag {

  ALIAS("ALIAS", text),

  SIGNATURE("SIGNATURE", text),

  FCB_REPORT_TYPE("Fcbreporttype", numeric),

  PRD_CALL_NUMBER("Prdcallnumber", numeric),

  FCB_PKB_STATUS("Fcbpkbstatus", numeric),

  FCB_SURNAME("Fcbsurname", text),

  FCB_NAME("Fcbname", text),

  FCB_FATHERS_NAME("Fcbfathersname", text),

  FCB_GENDER("Fcbgender", text),

  FCB_IIN("Fcbiin", text),

  FCB_BIRTH_NAME("Fcbbirthname", text),

  FCB_EDUCATION("Fcbeducation", numeric),

  FCB_MATRIAL_STATUS("Fcbmatrialstatus", numeric),

  FCB_COUNTRY_OF_BIRTH("Fcbcountryofbirth", numeric),

  FCB_REGION_OF_BIRTH("Fcbregionofbirth", numeric),

  FCB_CITY_OF_BIRTH("Fcbcityofbirth", text),

  FCB_NUMBER_OF_CHILDERN("Fcbnumberofchildern", numeric),

  FCB_NUMBER_OF_DEPENDENTS("Fcbnumberofdependents", numeric),

  FCB_STREET("Fcbstreet", text),

  APP_DATE_OF_BIRTH("Appdateofbirth", date),

  APP_DATE_OF_EXPIRATION("Appdateofexpiration", date),

  FCB_CITY("Fcbcity", text),

  APP_IIN("Appiin", text),

  FCB_ZIP_CODE("Fcbzipcode", text),

  SCORECARD("Scorecard", no_array),

  SCORECARD_ID("ScorecardId", text),

  SCORECARD_NAME("ScorecardName", text),

  SCORE("Score", numeric),

  APP_VISUAL_NEGATIVE("Appvisualnegative", numeric),

  APP_DOCUMENT_TYPE("Appdocumenttype", numeric),

  FCB_REGION("Fcbregion", text),

  FCB_COUNTRY("Fcbcountry", text),

  FCB_NUMBER("Fcbnumber", text),

  FCB_CELL_ULAR_PHONE("Fcbcellularphone", text),

  FCB_HOME_PHONE("Fcbhomephone", text),

  FCB_OFF_ICE_PHONE("Fcbofficephone", text),

  FCB_EMAIL("Fcbemail", text),

  FCB_EMPLOYEES_SALARY("Fcbemployeessalary", numeric),

  FCB_DOC_DATE_OF_REGISTRATION("Fcbdocdateofregistration", date, I, 30),

  FCB_DOC_DATE_OF_ISSUANCE("Fcbdocdateofissuance", date, I, 30),

  FCB_DOC_DATE_OF_EXPIRATION("Fcbdocdateofexpiration", date, I, 30),

  FCB_DOC_DOCUMENT_TYPE("Fcbdocdocumenttype", text, I, 30),

  FCB_DOC_ISSUANCE_LOCATION("Fcbdocissuancelocation", text, I, 30),

  FCB_DOC_NUMBER("Fcbdocnumber", text, I, 30),

  FCB_BORROWER_CLASSIFICATION("Fcbborrowerclassification", numeric),

  FCB_PATENT("Fcbpatent", text),

  APP_REGION_CODE("Appregioncode", text),

  FCB_RESIDENT("Fcbresident", numeric),

  FCB_SUBJECTS_POSITION("Fcbsubjectsposition", numeric),

  FCB_CITI_ZENSHIP("Fcbcitizenship", numeric),

  FCB_SUBJECT_SEMPLOYMENT("Fcbsubjectsemployment", numeric),

  FCB_FOREIGNERS_CITI_ZENSHIP("Fcbforeignerscitizenship", text),

  FCB_ECONOMIC_ACTIVITY_GROUP("Fcbeconomicactivitygroup", numeric),

  FCB_NUMBER_OF_QUERIES360("Fcbnumberofqueries360", numeric),

  FCB_NUMBER_OF_QUERIES180("Fcbnumberofqueries180", numeric),

  FCB_NUMBER_OF_QUERIES120("Fcbnumberofqueries120", numeric),

  FCB_NUMBER_OF_QUERIES90("Fcbnumberofqueries90", numeric),

  FCB_NUMBER_OF_QUERIES30("Fcbnumberofqueries30", numeric),

  FCB_NEGCL_TYPE("Fcbnegcltype", numeric, I, 30),

  APP_VISUAL_NEGATIVE_PREVIOUS("Appvisualnegativeprevious", numeric, I, 20),

  FCB_NEGCL_NEGATIVE_STATUS_OF_CLIENT("Fcbnegclnegativestatusofclient", numeric, I, 30),

  FCB_NEGCL_REGISTRATION_DATE("Fcbnegclregistrationdate", date, I, 30),

  APP_VISUAL_NEGATIVE_PREVIOUS_DATE("Appvisualnegativepreviousdate", date, I, 20),

  FCB_ADD_INFO_FROM_PUBLIC_SOURCES_REFRESH_DATE("Fcbaddinfofrompublicsourcesrefreshdate", date, I, 20),

  FCB_ADD_INFO_FROM_PUBLIC_SOURCES_ACTUAL_DATE("Fcbaddinfofrompublicsourcesactualdate", date, I, 20),

  FCB_NUMBER_OF_EXISTING_CONTRACTS("Fcbnumberofexistingcontracts", numeric),

  FCB_BORROWERTCNUMBEROFTERMINATEDCONTRACTS("Fcbborrowertcnumberofterminatedcontracts", numeric),

  FCB_DOC_NAME("Fcbdocname", numeric, I, 30),

  LAYOUT("LAYOUT"),

  FCB_CONTRACT_STATUS_CLIENT("Fcbcontractstatus", numeric, I, 50),

  FCB_ADD_INFO_FROM_PUBLIC_SOURCES_SOURCE("Fcbaddinfofrompublicsourcessource", numeric, I, 20),

  FCB_VALUE_OF_GUARANTEE("Fcbvalueofguarantee", numeric, I, 50),

  FCB_TYPE_OF_GUARANTEE("Fcbtypeofguarantee", numeric, I, 50),

  FCB_CONTRACT_CONTRACT_STATUS("Fcbcontractcontractstatus", numeric, I, 50),

  FCB_CONTRACT_PHASE_OF_CONTRACT("Fcbcontractphaseofcontract", numeric, I, 50),

  FCB_CONTRACT_PAYMENT_COUNT("Fcbcontractpaymentcount", numeric, I, 50),

  FCB_ADD_INFO_FROM_PUBLIC_SOURCES_STATUS("Fcbaddinfofrompublicsourcesstatus", numeric, I, 20),

  FCB_CONTRACT_TYPE_OF_FOUNDING("Fcbcontracttypeoffounding", numeric, I, 50),

  FCB_CONTRACT_PURPOSE_OF_CREDIT("Fcbcontractpurposeofcredit", numeric, I, 50),

  FCB_CONTRACT_AMOUNT("Fcbcontractamount", numeric, I, 50),

  FCB_CONTRACT_GRACEPAY("Fcbcontractgracepay", numeric, I, 50),

  FCB_CONTRACT_GRACEPRINCIPAL("Fcbcontractgraceprincipal", numeric, I, 50),

  FCB_CONTRACT_FINANCIALIN_STITUTION("Fcbcontractfinancialinstitution", numeric, I, 50),

  FCB_CONTRACT_SUBJECTROLE("Fcbcontractsubjectrole", numeric, I, 50),

  FCB_CONTRACT_NUMBER_OF_INSTALMENTS("Fcbcontractnumberofinstalments", numeric, I, 50),

  FCB_CONTRACT_NUMBER_OF_OVERDUEINSTALMENTS("Fcbcontractnumberofoverdueinstalments", numeric, I, 50),

  FCB_CONTRACT_INTERESTRATE("Fcbcontractinterestrate", numeric, I, 50),

  FCB_CONTRACT_INSTALMENT_AMOUNT("Fcbcontractinstalmentamount", numeric, I, 50),

  FCB_CONTRACT_MONTHLYINSTALMENT_AMOUNT("Fcbcontractmonthlyinstalmentamount", numeric, I, 50),

  FCB_CONTRACT_OVERDUE_AMOUNT("Fcbcontractoverdueamount", numeric, I, 50),

  FCB_CONTRACT_OUT_STANDING_AMOUNT("Fcbcontractoutstandingamount", numeric, I, 50),

  FCB_CONTRACT_METHOD_OF_PAYMENTS("Fcbcontractmethodofpayments", numeric, I, 50),

  FCB_CONTRACT_PERIODICITY_OF_PAYMENTS("Fcbcontractperiodicityofpayments", numeric, I, 50),

  FCB_CONTRACT_TOTAL_AMOUNT_TITLE("FcbcontracttotalamountTitle", numeric, I, 50),

  FCB_CONTRACT_NUMBER_OF_OUT_STANDING_INSTALMENTS("Fcbcontractnumberofoutstandinginstalments", numeric, I, 50),

  FCB_CONTRACT_CREDIT_LIMIT_TITLE("FcbcontractcreditlimitTitle", numeric, I, 50),

  FCB_OVERDUE_AMOUNT_MAX("Fcboverdueamountmax", numeric, I, 50),

  FCB_CONTRACT_RESIDUAL_AMOUNT("Fcbcontractresidualamount", numeric, I, 50),

  GCVPPAYMENTVALUE("Gcvppaymentvalue", numeric, I, 50),

  FCB_NUMBER_OF_OVERDUE_INSTALMENTS_MAX("Fcbnumberofoverdueinstalmentsmax", numeric, I, 50),

  FCB_CONTRACT_CURRENCY("Fcbcontractcurrency", text, I, 50),

  IRTREATMENTTREERESULTS("IrTreatmentTreeResults", no_array, I, 50),

  FCB_CONTRACT_TYPE_CODE("Fcbcontracttypecode", text, I, 50),

  FCB_CONTRACT_TYPE("Fcbcontracttype", text, I, 50),

  FCB_CONTRACT_CLASSIFICATION_OF_CONTRACT("Fcbcontractclassificationofcontract", text, I, 50),

  FCB_CONTRACT_CODE_OF_CONTRACT("Fcbcontractcodeofcontract", text, I, 50),

  FCB_CONTRACT_PLACE_OF_DISBURSEMENT("Fcbcontractplaceofdisbursement", text, I, 50),

  FCB_CONTRACT_AGREEMENT_NUMBER("Fcbcontractagreementnumber", text, I, 50),

  FCB_CONTRACT_CURRENCY_CODE("Fcbcontractcurrencycode", text, I, 50),

  GCVPPAYMENTSENDER("Gcvppaymentsender", text, I, 50),

  GCVPPAYMENTBIN("Gcvppaymentbin", text, I, 50),

  FCB_CONTRACT_DATE_OF_APPLICATION("Fcbcontractdateofapplication", date, I, 50),

  FCB_CONTRACT_DATE_OF_CREDIT_START("Fcbcontractdateofcreditstart", date, I, 50),

  FCB_CONTRACT_DATE_OF_REALRE_PAYMENT("Fcbcontractdateofrealrepayment", date, I, 50),

  FCB_CONTRACT_DATE_OF_CREDIT_END("Fcbcontractdateofcreditend", date, I, 50),

  FCB_CONTRACT_LAST_UPDATE("Fcbcontractlastupdate", date, I, 50),

  GCVPPAYMENTDATE("Gcvppaymentdate", date, I, 50),

  FCB_DATE_OF_BIRTH_DATE("Fcbdateofbirth", date),

  RESULT_S001_RANDOM_NUMBER01("Results001RandomNumber01", numeric),

  RESULT_S002_RANDOM_NUMBER02("Results002RandomNumber02", numeric),

  RESULT_S003_RANDOM_NUMBER03("Results003RandomNumber03", numeric),

  FCBP_CALENDAR_OVERDURE("Fcbpcalendar_overdure", numeric, I, 50),

  FCBP_CALENDAR_VALUE("Fcbpcalendar_value", numeric, I, 50),

  FCBCONTRACTREF("Fcbcontractref", numeric, I, 50),

  ATFRULESNUMBER("Atfrulesnumber", numeric, I, 50),

  EXT_CHECKS_ABSLOANOVERDURE("Extchecksabsloanoverdure", numeric, I, 20),

  EXT_CHECKS_ABSLOANOVERDUREDAYS("Extchecksabsloanoverduredays", numeric, I, 20),

  EXT_CHECKS_ABSINTERESTOVERDURE("Extchecksabsinterestoverdure", numeric, I, 20),

  FCBP_CALENDAR_DATE("Fcbpcalendar_date", date, I, 50),

  EXT_CHECKS_ABSINTERESTOVERDUREDAYS("Extchecksabsinterestoverduredays", numeric, I, 20),


  APP_BIOMETRY("Appbiometry", numeric),

  RF("Rf", numeric),

  RESULTSOFFERSPAYMENT("Resultsofferspayment", numeric),

  RESULTSOFFERSAMOUNTINHAND("Resultsoffersamountinhand", numeric),

  APPPOLKOD("Apppolkod", text),

  TREATMENTTREEID("TreatmentTreeId", text),

  TREATMENTTREENAME("TreatmentTreeName", text),

  LEAFNODEID("LeafNodeId", text),

  LEAFNODENAME("LeafNodeName", text),

  OUTCOMEID("OutcomeId", text),

  OUTCOMENAME("OutcomeName", text),

  TREATMENTTABLEID("TreatmentTableId", text),

  TREATMENTTABLENAME("TreatmentTableName", text),

  TREATMENTID("TreatmentId", text),

  TREATMENTNAME("TreatmentName", text),

  RESULTSOFFERSACTIVEOFFER("Resultsoffersactiveoffer", text),

  APPFILIAL("Appfilial", text),

  APP_PHONE_HOME("Appphonehome", text),

  APP_PHONE_WORK("Appphonework", text),

  APP_PHONE_1("Appphone1", text),

  APP_PHONE_2("Appphone2", text),

  APPSMSKOD("Appsmskod", text),

  RESULTSOFFERSAMOUNT("Resultsoffersamount", numeric),

  APPADDINCOME("Appaddincome", numeric),

  APPINCOME("Appincome", numeric),

  ABSUNREGLA("Absunregla", numeric),

  GCVPLASTPAYMENTDATE("Gcvplastpaymentdate", date),

  APPDATEISSUE("Appdateissue", date),

  EXT_CHECKS_ABSINSTALMENTAMOUNT("Extchecksabsinstalmentamount", numeric),

  EXT_CHECKS_ABSMONTHLYINSTALMENTAMOUNT("Extchecksabsmonthlyinstalmentamount", numeric),

  GCVPRETURNCODE("Gcvpreturncode", numeric),

  GCVPNOFPAYMENTS("Gcvpnofpayments", numeric),

  GCVPNMWPAYMENTS("Gcvpnmwpayments", numeric),

  GCVPMAXNPAY("Gcvpmaxnpay", numeric),

  GCVPOTHERFISPAYMENT("Gcvpotherfispayment", numeric),

  GCVPCLIENTTYPE("Gcvpclienttype", numeric),

  GCVPAVERAGEMONTHLYPAYMENTSTOPENSIONFUND("Gcvpaveragemonthlypaymentstopensionfund", numeric),

  GCVPAVERAGEMONTHLYPENSION("Gcvpaveragemonthlypension", numeric),

  GCVPQUERYTYPE("Gcvpquerytype", numeric),

  RESULTSOFFERSRISKBASEDINTERESTRATE("Resultsoffersriskbasedinterestrate", numeric),

  RESULTSSETCLIENTTYPE("Resultssetclienttype", numeric),

  FCB_TPAYMENT("Fcbtpayment", numeric),

  VERDECISION("Verdecision", numeric),

  APPRESIDENT("Appresident", numeric),

  SBDECISION("Sbdecision", numeric),

  ABS_SLAMMOUNT("Absslammount", numeric),

  PRD_CURRENCY_CODE("Prdcurrencycode", text),

  VERREASON("Verreason", text),

  PRD_RATE("Prdrate", numeric),

  PRD_PAYMENT_TYPE("Prdpaymenttype", numeric),

  PRD_INSURANCE("Prdinsurance", numeric),

  PRD_LOAN_AMOUNT("Prdloanamount", numeric),

  PRD_TERM("Prdterm", numeric),

  PRD_PRODUCT_CODE("Prdproductcode", text),

  EXT_CHECKS_BLFIS("Extchecksblfis", numeric),

  EXT_CHECKS_BLEMPL("Extchecksblempl", numeric),

  EXT_CHECKS_BL_PHONE("Extchecksblphone", numeric),

  EXT_CHECKS_BL_DOC("Extchecksbldoc", numeric),

  EXT_CHECKS_BL_ADDRESS("Extchecksbladdress", numeric),

  EXT_CHECKS_TERRASOFTHASACTIVEAPPLICATION("Extchecksterrasofthasactiveapplication", numeric),

  EXT_CHECKS_SAKDHASACTIVEAPPLICATION("Extcheckssakdhasactiveapplication", numeric),

  EXT_CHECKS_SAKDRHASACTIVEAPPLICATION("Extcheckssakdrhasactiveapplication", numeric),

  EXT_CHECKS_UCHASACTIVEAPPLICATION("Extchecksuchasactiveapplication", numeric),

  EXT_CHECKS_ABSAFFILATIONCHECK("Extchecksabsaffilationcheck", numeric),

  EXT_CHECKS_ABSTERRORIST("Extchecksabsterrorist", numeric),

  EXT_CHECKS_ABSBORRDISABLED("Extchecksabsborrdisabled", numeric),

  EXT_CHECKS_ABSTAXNUMBERCANCELED("Extchecksabstaxnumbercanceled", numeric),

  EXT_CHECKS_ABSIINGOOD("Extchecksabsiingood", numeric),

  EXT_CHECKS_UCNEXTAPPLICATIONDATE("Extchecksucnextapplicationdate", date),

  EXT_CHECKS_ABSARREST("Extchecksabsarrest", numeric),

  EDITION("EDITION", numeric),

  OBJECTIVE("OBJECTIVE", text),

  EDITIONDATE("EDITIONDATE", date),

  ERRORCOUNT("ERRORCOUNT", text),

  EXT_CHECKS_SUCHASCLOSEDAPPLICATION("Extchecksuchasclosedapplication", numeric),

  ABS_ABSULAMMOUNT("Absulammount", numeric),

  ABS_UCLAMMOUNT("Absuclammount", numeric),

  OCONTROL("OCONTROL", no_array),

  RESULT_SOFFERSTERM("Resultsoffersterm",numeric);

  private String node;

  private DataType dataType;

  private ArrayNameTagScoring arrayNameTag;

  private Integer cycle;

  ScoringXMLTag(String node, DataType dataType) {
    this.node = node;
    this.dataType = dataType;
  }

  ScoringXMLTag(String node, DataType dataType, ArrayNameTagScoring arrayNameTag, Integer cycle) {
    this.node = node;
    this.dataType = dataType;
    this.arrayNameTag = arrayNameTag;
    this.cycle = cycle;
  }

  public String getNode() {
    return node;
  }

  public DataType getDataType() {
    return dataType;
  }

  public ArrayNameTagScoring getArrayNameTag() {
    return arrayNameTag;
  }

  public Integer getCycle() {
    return cycle;
  }

  ScoringXMLTag(final String node) {
    this.node = node;
  }

  @Override
  public String toString() {
    return node;
  }
}
