package br.ufba.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contato.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContatoDao contatoDao();
}
