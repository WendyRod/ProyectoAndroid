package Data;

import android.provider.BaseColumns;

public class Estructura_BD {

    public Estructura_BD() {
    }

    public static abstract class ClienteInfo implements BaseColumns {

        //Tabla de clientes
        public static final String TABLE_NAME = "cliente";
        public static final String NAME = "name";
        public static final String ID = "id";
        public static final String PHONE_NUMBER = "phoneNumber";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + ClienteInfo.TABLE_NAME + " (" +
                        ClienteInfo.ID + " INTEGER PRIMARY KEY," +
                        ClienteInfo.NAME + " " + TEXT_TYPE + COMMA_SEP +
                        ClienteInfo.PHONE_NUMBER + " " + TEXT_TYPE + ");";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + ClienteInfo.TABLE_NAME + ";";
    }

    public static abstract class ProductosInfo implements BaseColumns {

        //Tabla de productos

        public static final String TABLE_NAME = "producto";
        public static final String NAME_P = "nameP";
        public static final String ID_P = "idP";
        public static final String PRECIO_VENTA = "precio-ventaP";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + ProductosInfo.TABLE_NAME + " (" +
                        ProductosInfo.ID_P + " INTEGER PRIMARY KEY," +
                        ProductosInfo.NAME_P + " " + TEXT_TYPE + COMMA_SEP +
                        ProductosInfo.PRECIO_VENTA + " " + TEXT_TYPE + ");";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Estructura_BD.ProductosInfo.TABLE_NAME + ";";
    }
}
