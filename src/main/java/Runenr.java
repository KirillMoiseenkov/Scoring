import com.example.demo.DemoApplication;
import com.example.demo.MyXMLStringUtils;
import com.example.demo.models.*;
import com.example.demo.repo.*;
import com.example.demo.utils.ScoringXMLUtils;
import com.example.demo.utils.factory.ScoringXMLTagCreator;
import com.example.demo.utils.factory.ScoringXMLTagCreatorCommon;
import com.example.demo.utils.factory.model.ScoringXMLTagCommonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.utils.DataType;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class Runenr {

    @Autowired
    GooodsRepo gooodsRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderGoodsRepo orderGoodsRepo;

    @Autowired
    PartnersRepo partnersRepo;

    @Autowired
    POSRepo posRepo;

    @Autowired
    ScoringXMLUtils utils;

    @Autowired
    ScoringXMLTagCreator scoringXMLTagCreator;

    @Test
    @Transactional
    @Rollback(false)
    public void test(){





        Optional<Order> order = orderRepo.findById(1L);
//        Partners partners = new Partners();

//        partners.setCity("Saratov");
//        partners.setCode(123L);
//
//        POS pos = new POS();
//
//        pos.setCity("Saratov");
//        pos.setCode(456L);


//        Order order = new Order();



  //      OrderGoods orderGoods = new OrderGoods();


//        order.get().setPartners(partners);
//        order.get().setPos(pos);


        //orderGoods.setGoods(goods);
        //orderGoods.setOrders(order.get());

        List<OrderGoods> orderGoodsList  = new ArrayList<>();

        for(int i =0; i<10;i++)
        {
            Goods goods = new Goods();

            goods.setName(String.valueOf(i));


            OrderGoods goodsC = new OrderGoods();

            goodsC.setOrders(order.get());

            goodsC.setGoods(goods);

            goodsC.setGoodsCost((long) i);
            goodsC.setGoodsCount((long) i);



            orderGoodsList.add(goodsC);

        }

//        goods.getOrderGoods().add(orderGoods);
//        order.get().getOrderGoods().add(orderGoods);

        //orderRepo.saveAndFlush(order.get());
        //gooodsRepo.saveAndFlush(goods);

        orderGoodsList.forEach(orderGoodsRepo::save);


    }



    @Test
    public void testRepoBidi(){

        Optional<Order> order = orderRepo.findById(1L);
        Optional<Goods> goods = gooodsRepo.findById(1L);



        System.out.println(order.get().getId());
        System.out.println(goods.get().getId());

    }


    @Test
    @Transactional
    @Rollback(false)
    public void TestRequest(){


        Optional<Order> order = orderRepo.findById(1L);



//        System.out.println(order.get().getOrderGoods().toString() + " some");



        //OrderGoods orderGoods = orderGoodsRepo.findOrderGoodsByOrders(order.get());



        //System.out.println(orderGoods.getGoods().getName());
    }

    public ScoringXMLTagCreatorCommon scoringXMLTagCreatorCommon = new ScoringXMLTagCreatorCommon();

    @Test
    @Transactional
    public void test2() throws IOException, XMLStreamException {

        List<OrderGoods> goodsList = orderGoodsRepo.findOrderGoodsByOrdersId(1L);

        String xml = MyXMLStringUtils.getXmlToString();

//
//
//        for(int i =30; i>=0;i--){
//
//            if(i+1 <= goodsList.size()){
//
//                xml = addToXml(xml, "Prdpointofsale" ,goodsList.get(i).getOrders().getPos().getCode(),DataType.numeric);
//
//            }else {
//                xml =  addToXml(xml, "Prdpointofsale", "-99", DataType.numeric);
//            }
//        }
//
//        for(int i =30; i>=0;i--){
//
//            if(i+1 <= goodsList.size()){
//
//                xml = addToXml(xml, "Prdpartner" ,goodsList.get(i).getOrders().getPartners().getCode(),DataType.numeric);
//
//            }else {
//                xml =  addToXml(xml, "Prdpartner", "-99", DataType.numeric);
//            }
//        }
//
//        for(int i =30; i>=0;i--){
//
//            if(i+1 <= goodsList.size()){
//
//                xml = addToXml(xml, "Goodscode" ,goodsList.get(i).getGoods().getName(),DataType.text);
//
//            }else {
//                xml =  addToXml(xml, "Goodscode", "-99", DataType.text);
//            }
//        }
//
//        for(int i =30; i>=0;i--){
//
//            if(i+1 <= goodsList.size()){
//
//                xml = addToXml(xml, "Goodsn" ,goodsList.get(i).getGoodsCount(),DataType.text);
//
//            }else {
//                xml =  addToXml(xml, "Goodsn", "-99", DataType.text);
//            }
//        }
//
//        for(int i =30; i>=0;i--){
//
//            if(i+1 <= goodsList.size()){
//
//                xml = addToXml(xml, "Goodsprice" ,goodsList.get(i).getGoodsCost(),DataType.text);
//
//            }else {
//                xml =  addToXml(xml, "Goodsprice", "-99", DataType.text);
//            }
//        }




         xml = forOrderList(goodsList,xml, "Goodsprice",DataType.numeric);
         xml = forOrderList(goodsList,xml, "Goodsn" ,DataType.numeric);
         xml = forOrderList(goodsList,xml, "Goodscode" ,DataType.numeric);
         xml = forOrderList(goodsList,xml, "Prdpointofsale" ,DataType.numeric);
         xml = forOrderList(goodsList,xml, "Prdpartner" ,DataType.numeric);

        System.out.println(xml);



    }






    public String forOrderList(List<OrderGoods> orderGoods, String xml, String tagName, DataType dataType){

        AtomicReference<String> MyXML = new AtomicReference<String>();

        MyXML.set(xml);


        orderGoods.forEach(orGoods -> {

            switch (tagName){

                case "Goodsprice":MyXML.set(addToXml(MyXML.get(),tagName,orGoods.getGoodsCost(),dataType));
                    break;
                case "Goodsn":MyXML.set(addToXml(MyXML.get(),tagName,orGoods.getGoods().getName(),dataType));
                    break;
                case "Goodscode":MyXML.set(addToXml(MyXML.get(),tagName,orGoods.getGoodsCount(),dataType));
                    break;
                case "Prdpointofsale":MyXML.set(addToXml(MyXML.get(),tagName,orGoods.getOrders().getPos().getCode(),dataType));
                    break;
                case "Prdpartner":MyXML.set(addToXml(MyXML.get(),tagName,orGoods.getOrders().getPartners().getCode(),dataType));
                    break;
            }

        });

        for(int i = 30 - orderGoods.size();  i>0; i--){

            MyXML.set(addToXml(MyXML.get(),tagName,"-99",dataType));

        }



        return MyXML.get();
    }

    public String addToXml(String xml, String tagName, Object value, DataType dataType) {

        ScoringXMLTagCommonEntity scoringXMLTagCommonEntity = scoringXMLTagCreatorCommon.createScoringTagEntity(dataType,tagName,value.toString());

        try {
            xml = utils.createScoringTag(xml, scoringXMLTagCommonEntity);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return xml;
    }

}
