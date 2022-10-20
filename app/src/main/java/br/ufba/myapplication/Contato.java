package br.ufba.myapplication;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {
        @Index(value = {"telefone"}, unique = true)
})
public class Contato {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public String nome;
    public String telefone;
}
