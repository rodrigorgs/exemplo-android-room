package br.ufba.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContatoDao {

    @Query("SELECT * FROM contato")
    public List<Contato> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Contato contato);
}
