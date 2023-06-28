package org.javakaya;

import Data.RelationalDbManager;

public class Main {
    public static void main(String[] args) {

        RelationalDbManager cc = new RelationalDbManager();
        cc.Connect();
        cc.InsertData(1, "Mercedes");
        //cc.DeleteData(1);
        cc.GetData();
    }
}