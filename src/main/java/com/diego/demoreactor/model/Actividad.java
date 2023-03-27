package com.diego.demoreactor.model;

import java.util.Objects;

public class Actividad {
    private int id;
    private String tipoActividad;
    private String descripcion;

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", tipoActividad='" + tipoActividad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public Actividad(int id, String tipoActividad, String descripcion) {
        this.id = id;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad = (Actividad) o;
        return id == actividad.id && Objects.equals(tipoActividad, actividad.tipoActividad) && Objects.equals(descripcion, actividad.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoActividad, descripcion);
    }
}
