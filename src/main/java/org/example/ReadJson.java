package org.example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static String url;
    public static String ItemsArray [] = new String[15];
    public static String user_Fahim;
    public static String user_Polash;
    public static String user_Siam;
    public static String password;
    public static String ContactsSearchInfo;
    public static String PreInvoiceSearchInfo;
    public static String PreInvoiceDistributorSearch;
    public static String PreInvoiceItemQuantity;
    public static String PreInvoiceItems [] = new String[15];
    public static String PreviousPendingDeliveryItems [] = new String[15];
    public static String PreviousPendingDeliveryDistributorSearch;
    public static String PreviousPendingDeliveryItemQuantity;
    public static String PreviousPendingDeliverySearchInfo;
    public static String PreviousPendingDeliveryStore;
    public static String AppsSearchInfo;
    public static String AppsDisplayName;
    public static String AppsName;
    public static String AppsEditedDisplayName;
    public static String AppsEditedName;
    public static String AppsLink;
    public static String AppsEmployeeInfo [] = new String[10];
    public static String OrderItems [] = new String[15];
    public static String OrderSearchInfo;
    public static String OrderItemQuantity;
    public static String OrderDistributorSearch;
    public static String OrderNote;
    public static String CancelOrderSearchInfo;
    public static String CancelOrderDistributorSearch;
    public static String CancelOrderItemQuantity;
    public static String CancelOrderNote;
    public static String DistributorInvoiceSearchInfo;
    public static String DistributorInvoiceDistributorSearch;
    public static String DistributorInvoiceStore;
    public static String DistributorInvoiceNote;
    public static String DistributorInvoiceItemQuantity;



    public static String[] readJsonData(){
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("Test_Data.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            // Read data from the "Login" object
            JSONObject loginObject = (JSONObject) jsonObject.get("Login");
            url = (String) loginObject.get("url");
            user_Fahim = (String) loginObject.get("user_Fahim");
            user_Polash = (String) loginObject.get("user_Polash");
            user_Siam = (String) loginObject.get("user_Siam");
            password = (String) loginObject.get("password");

            // Read data from the "Contacts" object
            JSONObject ContactsObject = (JSONObject) jsonObject.get("Contacts");
            ContactsSearchInfo = (String) ContactsObject.get("SearchInfo");

            // Read data from the "Items" object
            JSONObject ItemsObject = (JSONObject) jsonObject.get("Items");
            for (int i = 0; i < ItemsArray.length; i++) {
                ItemsArray[i] = (String) ItemsObject.get("Item"+(i+1));
            }

            // Read data from the "PreInvoice" object
            JSONObject PreInvoiceObject = (JSONObject) jsonObject.get("PreInvoice");
            PreInvoiceSearchInfo = (String) PreInvoiceObject.get("SearchInfo");
            PreInvoiceItemQuantity = (String) PreInvoiceObject.get("ItemQuantity");
            PreInvoiceDistributorSearch = (String) PreInvoiceObject.get("DistributorSearch");
            PreInvoiceItems = ItemsArray;


            // Read data from the "PreviousPendingDelivery" object
            JSONObject PreviousPendingDeliveryObject = (JSONObject) jsonObject.get("PreviousPendingDelivery");
            PreviousPendingDeliverySearchInfo = (String) PreviousPendingDeliveryObject.get("SearchInfo");
            PreviousPendingDeliveryItemQuantity = (String) PreviousPendingDeliveryObject.get("ItemQuantity");
            PreviousPendingDeliveryDistributorSearch = (String) PreviousPendingDeliveryObject.get("DistributorSearch");
            PreviousPendingDeliveryStore = (String) PreviousPendingDeliveryObject.get("Store");
            PreviousPendingDeliveryItems = ItemsArray;

            // Read data from the "Apps" object
            JSONObject AppsObject = (JSONObject) jsonObject.get("Apps");
            AppsSearchInfo = (String) AppsObject.get("SearchInfo");
            AppsName = (String) AppsObject.get("Name");
            AppsDisplayName = (String) AppsObject.get("Display Name");
            AppsLink = (String) AppsObject.get("Link");
            AppsEditedName = (String) AppsObject.get("Edited Name");
            AppsEditedDisplayName = (String) AppsObject.get("Edited Display Name");
            for (int i = 0; i < AppsEmployeeInfo.length; i++) {
                AppsEmployeeInfo[i] = (String) AppsObject.get("Employee info"+(i+1));
            }

            // Read data from the "Order" object
            JSONObject OrderObject = (JSONObject) jsonObject.get("Order");
            OrderSearchInfo = (String) OrderObject.get("SearchInfo");
            OrderItemQuantity = (String) OrderObject.get("ItemQuantity");
            OrderDistributorSearch = (String) OrderObject.get("DistributorSearch");
            OrderNote = (String) OrderObject.get("Note");
            OrderItems = ItemsArray;

            // Read data from the "CancelOrder" object
            JSONObject CancelOrderObject = (JSONObject) jsonObject.get("CancelOrder");
            CancelOrderSearchInfo = (String) CancelOrderObject.get("SearchInfo");
           CancelOrderItemQuantity = (String) CancelOrderObject.get("ItemQuantity");
           CancelOrderDistributorSearch = (String) CancelOrderObject.get("DistributorSearch");
           CancelOrderNote = (String) CancelOrderObject.get("Note");

           // Read data from the "DistributorInvoice" object
            JSONObject DistributorInvoiceObject = (JSONObject) jsonObject.get("DistributorInvoice");
            DistributorInvoiceSearchInfo = (String) DistributorInvoiceObject.get("SearchInfo");
           DistributorInvoiceItemQuantity = (String) DistributorInvoiceObject.get("ItemQuantity");
           DistributorInvoiceDistributorSearch = (String) DistributorInvoiceObject.get("DistributorSearch");
           DistributorInvoiceStore = (String) DistributorInvoiceObject.get("Store");
           DistributorInvoiceNote = (String) DistributorInvoiceObject.get("Note");





        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        String[] array= {};
        return array;
    }
}
