package me.rarstman.rarstapi.database;

import java.sql.Connection;

public interface Database {

    Connection getConnection();

}