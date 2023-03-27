package com.diego.demoreactor.model;

public class Dispositivo {
    private int id;
    private String tipo;
    private String imei;


    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }

    public Dispositivo(int id, String tipo, String imei) {
        this.id = id;
        this.tipo = tipo;
        this.imei = imei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
