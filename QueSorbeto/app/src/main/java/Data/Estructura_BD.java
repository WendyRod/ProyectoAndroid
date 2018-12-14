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
        public static final String COD_P = "idP";
        public static final String PRECIO_VENTA = "precio_ventaP";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + ProductosInfo.TABLE_NAME + " (" +
                        ProductosInfo.COD_P + " INTEGER PRIMARY KEY," +
                        ProductosInfo.NAME_P + " " + TEXT_TYPE + COMMA_SEP +
                        ProductosInfo.PRECIO_VENTA + " " + TEXT_TYPE + ");";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Estructura_BD.ProductosInfo.TABLE_NAME + ";";

    }

    public static abstract class FacturaInfo implements BaseColumns {

        //Tabla de factura

        public static final String TABLE_NAME = "factura";
        private static int numeroF;
        public static final int NUMEROF = numeroF;
        public static final String CLIENTE = "cliente";
        public static final String PRODUCTO = "producto";
        private static int cantidad;
        public static final int CANTIDAD = cantidad;
        //public final date FECHA = fecha;

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FacturaInfo.TABLE_NAME + " (" +
                        FacturaInfo.NUMEROF + " INTEGER PRIMARY KEY," +
                        FacturaInfo.CLIENTE + " " + TEXT_TYPE + COMMA_SEP +
                        FacturaInfo.PRODUCTO + " " + TEXT_TYPE + COMMA_SEP +
                        FacturaInfo.CANTIDAD + " " + TEXT_TYPE + COMMA_SEP +
                        /*FacturaInfo.FECHA + " " + TEXT_TYPE +*/ ");";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Estructura_BD.FacturaInfo.TABLE_NAME + ";";

    }
}
