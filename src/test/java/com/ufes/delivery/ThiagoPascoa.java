package com.ufes.delivery;

import com.ufes.delivery.dao.ProdutoDAO;
import com.ufes.delivery.imposto.Imposto;
import com.ufes.delivery.model.Cliente;
import com.ufes.delivery.model.Desconto;
import com.ufes.delivery.model.Estabelecimento;
import com.ufes.delivery.model.EventoPedido;
import com.ufes.delivery.model.ItemPedido;
import com.ufes.delivery.model.Pedido;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

public class ThiagoPascoa {
    public ThiagoPascoa(){}
    private ProdutoDAO dao;
    private Cliente cliente;
    private Estabelecimento estabelecimento;
    
    @BeforeEach
    void carregaDao() {
        dao = ProdutoDAO.getInstance();
    }
    
    @Test
    @DisplayName("Validação do toString de PedidoVisitor para os casos não abordados por LucasC.")
    void CT001(){
        //Horário de início: 13:17
        //Horário de témino: 13:55
        //Arrange
        cliente = new Cliente("Thiago", 1000.0); //cria cliente
        estabelecimento = new Estabelecimento("Shop"); //cria estabelecimento
        Pedido pedido = new Pedido(1, cliente, estabelecimento, LocalTime.now()); //cria pedido
        String res;
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        DecimalFormat df = new DecimalFormat("0.00");
        //Act
        pedido.incluir(new ItemPedido(pedido, dao.buscaProdutoPorCodigo(7), 2));
        pedido.add(new Imposto("Imposto teste", 10, 32 ));
        pedido.add(new Desconto("Desconto teste", 9.1, 31.2));
        pedido.add(new EventoPedido(LocalDateTime.now(), "teste"));
        res = pedido.toString();
        //Assert
        Assertions.assertEquals("\n-------------------------------------------------------------------------------------------------"
                + "\nPedido: " + pedido.getNumero() 
                + ", data: " + pedido.getData().format(formatterData) + ", horario: " + pedido.getHora().format(formatterHora) 
                +", estado: " + pedido.getEstado()
                + "\nCliente: " + pedido.getCliente()
                + "\nEstabelecimento: " + pedido.getEstabelecimento()
                + "\nItens do pedido:"
                + "\n\t" 
                + pedido.getItens().get(0).toString()
                + "\nValor total dos itens R$: " + df.format(pedido.getValorTotal())
                + "\n\nDescontos concedidos:"
                + "\n\t"
                + pedido.getDescontosConcedidos().get(0).toString()
                + "\nValor total em descontos R$: " + df.format(pedido.getValorTotalDescontos())
                + "\n\nImpostos calculados:"
                + "\n\t"
                + pedido.getImpostos().get(0).toString()
                + "\nValor total em impostos R$: " + df.format(pedido.getValorTotalImpostos())
                + "\n\nValor total do pedido R$: " + df.format(pedido.getValorFinal())
                + "\n\nEventos no pedido:"
                + "\n\t"
                + pedido.getEventos().get(0).toString()
                + "\n\t"
                + pedido.getEventos().get(1).toString()
                + "\n\t"
                + pedido.getEventos().get(2).toString()
                , res);
    }
    
    @Disabled
    @Test
    @DisplayName("Cancelar um pedido que está aguardando pagamento")
    void CT002(){
        //Horário de início: 13:17
        //Horário de témino: xx:xx
        
        //Arrange
        
        //Act
        
        //Assert

    }
    
     @Disabled
    @Test
    @DisplayName("Cancelar um pedido que está aguardando pagamento")
    void CT003(){
        //Horário de início: 13:17
        //Horário de témino: xx:xx
        
        //Arrange
        
        //Act
        
        //Assert

    }
    
    @Disabled
    @Test
    @DisplayName("Cancelar um pedido que está aguardando pagamento")
    void CT004(){
        //Horário de início: 13:17
        //Horário de témino: xx:xx
        
        //Arrange
        
        //Act
        
        //Assert

    }
    
    @Disabled
    @Test
    @DisplayName("Cancelar um pedido que está aguardando pagamento")
    void CT005(){
        //Horário de início: 13:17
        //Horário de témino: xx:xx
        
        //Arrange
        
        //Act
        
        //Assert

    }
    
    
    
    
}
