package dto;

public class ProductoDTO {

    private String codigoProducto;
    private String nombre;
    private String gama;
    private String dimensiones;
    private String proveedor;
    private String descripcion;
    private int cantidadEnStock;
    private double precioVenta;
    private double precioProveedor;

    public ProductoDTO() {
    }

    public ProductoDTO(String codigoProducto, String nombre, String gama, String dimensiones, String proveedor,
            String descripcion, int cantidadEnStock, double precioVenta, double precioProveedor) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.gama = gama;
        this.dimensiones = dimensiones;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.precioVenta = precioVenta;
        this.precioProveedor = precioProveedor;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGama() {
        return gama;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setPrecioProveedor(double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }
}
