package br.unisul.pweb.quarta.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.domain.Categoria;
import br.unisul.pweb.quarta.domain.Cidade;
import br.unisul.pweb.quarta.domain.Cliente;
import br.unisul.pweb.quarta.domain.Endereco;
import br.unisul.pweb.quarta.domain.Estado;
import br.unisul.pweb.quarta.domain.Produto;
import br.unisul.pweb.quarta.domain.enums.TipoCliente;
import br.unisul.pweb.quarta.repositories.CategoriaRepository;
import br.unisul.pweb.quarta.repositories.CidadeRepository;
import br.unisul.pweb.quarta.repositories.ClienteRepository;
import br.unisul.pweb.quarta.repositories.EnderecoRepository;
import br.unisul.pweb.quarta.repositories.EstadoRepository;
import br.unisul.pweb.quarta.repositories.ProdutoRepository;
import br.unisul.pweb.quarta.domain.Estado;
import br.unisul.pweb.quarta.repositories.EstadoRepository;


@Service
public class DbService {
	
	@Autowired
	private CategoriaRepository catRep;
	
	@Autowired
	private EstadoRepository estRep;
	
	@Autowired
	private ProdutoRepository prodRep;
	
	@Autowired
	private CidadeRepository cidRep;
	
	@Autowired
	private ClienteRepository clieRep;
	
	@Autowired
	private EnderecoRepository endRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
=======
	private EstadoRepository estadoRepository;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Estado cat1 = new Estado(null, "Santa Catarina","SC");
		Estado cat2 = new Estado(null, "Parana","PR");
		Estado cat3 = new Estado(null, "Sao Paulo","SP");
		Estado cat4 = new Estado(null, "Rio Grande do Sul","RS");
		Estado cat5 = new Estado(null, "Minas Gerais","MG");
		Estado cat6 = new Estado(null, "Mato Grosso do Sul","MS");
		Estado cat7 = new Estado(null, "Bahia","BA");
		estadoRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		
		Estado e1 = new Estado(null, "Paraná","PR");
		Estado e2 = new Estado(null, "Santa Catarina","SC");
		Estado e3 = new Estado(null, "Rio Grande do Sul","RS");
		
		Cidade c1 = new Cidade(null, "Curitiba", e1);
		Cidade c2 = new Cidade(null, "Tubarão", e2);
		Cidade c3 = new Cidade(null, "Gravatal", e2);
		Cidade c4 = new Cidade(null, "Laguna", e2);
		Cidade c5 = new Cidade(null, "Porto Alegre", e3);
		Cidade c6 = new Cidade(null, "Guaíba", e3);
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2, c3, c4));
		e3.getCidades().addAll(Arrays.asList(c5, c6));
		
		Cliente cli1 = new Cliente(null, "Alexandre Schuelter", "alexandre-bn@hotmail.com", "11215275006", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("4896664065", "48988230485"));
		
		Endereco en1 = new Endereco(null, "Almir Santos Miranda ", "929", "Apto 402", "Dehon"     , "88704110", cli1, c2);
		Endereco en2 = new Endereco(null, "Hermínio João Santana", "112", "Casa"    , "Pouso Alto", "88735000", cli1, c3);
		cli1.getEnderecos().addAll(Arrays.asList(en1, en2));
		
		estRep.saveAll(Arrays.asList(e1,e2,e3));
		cidRep.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
		clieRep.saveAll(Arrays.asList(cli1));
		endRep.saveAll(Arrays.asList(en1, en2));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		catRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRep.saveAll(Arrays.asList(p1,p2,p3));
	}

}