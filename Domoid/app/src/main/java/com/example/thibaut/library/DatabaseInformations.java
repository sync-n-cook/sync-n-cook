package com.example.thibaut.library;

/**
 * An object which contains static informations about the SQLite database : version code, name of the tables, etc
 *
 * @author Thibaut Chamoux
 * @version 1.0 8/7/14
 *
 */
public class DatabaseInformations {

    // db name
    public static final String DB_NAME = "domoid";

    // db version
    public static final int DB_VERSION = 1;

    // table name
    public static final String TABLE_INGREDIENTS = "ingredients";

    // Table Columns names
    public static final String KEY_ID = "idingredients";
    public static final String KEY_IDCAT = "idcategorie";
    public static final String KEY_NAME = "nom";
    public static final String KEY_QUANTITY = "nom";
    public static final String KEY_DATE = "nom";

}
