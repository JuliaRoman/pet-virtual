package com.example.petvirtual;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String db_nome = "pet_virtual";
    private static final int db_version = 1;

    public BancoDeDados(@Nullable Context context) {
        super(context, db_nome, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tabelaUsuario = "CREATE TABLE usuario( \n" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "email_usuario VARCHAR(50) UNIQUE NOT NULL, \n" +
                "nome_usuario VARCHAR(50) NOT NULL, \n" +
                "senha_usuario VARCHAR(50) NOT NULL \n" +
                "); ";

        String tabelaPet = "CREATE TABLE pet( \n" +
                "id_pet INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "nome_pet VARCHAR(50) NOT NULL, \n" +
                "status_sono TINYINT NOT NULL, \n" +
                "status_fome TINYINT NOT NULL, \n" +
                "status_diversao TINYINT NOT NULL, \n" +
                "status_limpeza TINYINT NOT NULL, \n" +
                "fk_id_usuario TINYINT NOT NULL, \n" +
                "foreign key(fk_id_usuario) references usuario(id_usuario) \n" +
                "); ";

        String tabelaNotificacao = "CREATE TABLE notificacao( \n" +
                "id_notificacao INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "tit_notificacao VARCHAR(20) NOT NULL, \n" +
                "msg_notificacao VARCHAR(50) NOT NULL, \n" +
                "fk_id_pet TINYINT, \n" +
                "foreign key(fk_id_pet) references pet(id_pet) \n" +
                "); ";

        sqLiteDatabase.execSQL(tabelaUsuario);
        sqLiteDatabase.execSQL(tabelaPet);
        sqLiteDatabase.execSQL(tabelaNotificacao);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean cadastrarUsuario(Usuario usuario){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email_usuario", usuario.getEmail());
        values.put("nome_usuario", usuario.getNome());
        values.put("senha_usuario", usuario.getSenha());
        if(banco.insert("usuario", null, values) != -1){
            banco.close();
            return true;
        }else{
            banco.close();
            return false;
        }
    }

    public boolean cadastrarPet(Pet pet){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome_pet", pet.getNome());
        values.put("status_sono", pet.getSono());
        values.put("status_fome", pet.getFome());
        values.put("status_diversao", pet.getDiversao());
        values.put("status_limpeza", pet.getLimpeza());
        values.put("status_limpeza", pet.getLimpeza());
        values.put("fk_id_usuario", pet.getFkUsuario());
        if(banco.insert("pet", null, values) != -1){
            banco.close();
            return true;
        }else{
            banco.close();
            return false;
        }
    }

    @SuppressLint("Range")
    public boolean loginUsuario(Usuario usuario){
        SQLiteDatabase banco = getWritableDatabase();

        Cursor c = banco.rawQuery("SELECT * FROM usuario WHERE email_usuario = ' " + usuario.getEmail() + " ' ", null);

        while (c.moveToNext()){
            if(usuario.getEmail().equals(c.getString(c.getColumnIndex("email_usuario")))){
                if(usuario.getSenha().equals(c.getString(c.getColumnIndex("senha_usuario")))){
                    return true;
                }
            }
        }

        return false;
    }




}
