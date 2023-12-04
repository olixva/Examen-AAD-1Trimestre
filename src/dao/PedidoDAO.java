package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PedidoDTO;
import util.Conexion;

public class PedidoDAO {

    // Sentencia SELECT de pedidos entre fechas con todos los campos
    private static final String SQL_SELECT = "SELECT codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, codigo_cliente FROM pedido WHERE fecha_pedido BETWEEN ? AND ?";

    // Metodo para buscar pedidos entre dos fechas
    public List<PedidoDTO> buscarPedidosPorFecha(Date fechaInicio, Date fechaFin) {
        
        List<PedidoDTO> pedidos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT)) {

            pS.setDate(1, fechaInicio);
            pS.setDate(2, fechaFin);

            ResultSet rS = pS.executeQuery();

            while (rS.next()) {
                int codigoPedido = rS.getInt("codigo_pedido");
                Date fechaPedido = rS.getDate("fecha_pedido");
                Date fechaEsperada = rS.getDate("fecha_esperada");
                Date fechaEntrega = rS.getDate("fecha_entrega");
                String estado = rS.getString("estado");
                String comentarios = rS.getString("comentarios");
                int codigoCliente = rS.getInt("codigo_cliente");

                PedidoDTO pedido = new PedidoDTO(codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado,
                        comentarios, codigoCliente);

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }
}
