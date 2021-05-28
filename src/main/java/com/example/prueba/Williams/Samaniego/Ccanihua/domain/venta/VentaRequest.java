package com.example.prueba.Williams.Samaniego.Ccanihua.domain.venta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VentaRequest {

    @JsonProperty("idProducto")
    private int idProducto;
    @JsonProperty("cantidadProducto")
    private int cantidadProducto;
    @JsonProperty("nombreProducto")
    private String nombreProducto;
    @JsonProperty("montoTotal")
    private double montoTotal;

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
