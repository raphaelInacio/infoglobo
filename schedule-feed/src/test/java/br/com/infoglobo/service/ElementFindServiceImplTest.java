package br.com.infoglobo.service;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.infoglobo.domain.Description;
import br.com.infoglobo.domain.DescriptionType;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElementFindServiceImplTest {

	@Autowired
	private ElementFindService elementFindService;

	private static final String content = "<div class=\"foto componente_materia midia-largura-620\"> <img alt=\"Citigo é a versão do Skoda do Volkswagen up!  (Foto: Divulgação)\" height=\"413\" id=\"238662\" src=\"http://s2.glbimg.com/douTFl5Y2xkDIZP7tXWUv2CnlMM=/620x413/e.glbimg.com/og/ed/f/original/2017/08/23/citigo.jpg\" title=\"Citigo é a versão do Skoda do Volkswagen up!  (Foto: Divulgação)\" width=\"620\" /><label class=\"foto-legenda\">Citigo &#233; a vers&#227;o do Skoda do Volkswagen up! (Foto: Divulga&#231;&#227;o)</label></div> <p> &#160;</p> <p> A Skoda, marca mais em conta do grupo <a href=\"http://revistaautoesporte.globo.com/carros/volkswagen/\">Volkswagen</a>, n&#227;o tem muita rela&#231;&#227;o com o mercado brasileiro, mas isso pode mudar. Segundo o Automotive News Europe, a marca da Rep&#250;blica Checa ser&#225; a respons&#225;vel pela cria&#231;&#227;o de um novo modelo emergente da VW. O carro seria lan&#231;ado em 2020 e pode chegar ao Brasil.</p> <p> Pode ser a reedi&#231;&#227;o do Gol, embora isso s&#243; vai ser confirmado mais pr&#243;ximo da data de lan&#231;amento. O nome &#233; o de menos. Um novo modelo poderia substituir de uma vez s&#243; o veterano e tamb&#233;m o up!, que acabou de ser reestilizado, mas n&#227;o ter&#225; uma nova gera&#231;&#227;o em raz&#227;o dos altos custos da plataforma NSF (New Small Family, &#160;ou nova fam&#237;lia de pequenos). A pr&#243;pria Skoda tem uma vers&#227;o pr&#243;pria do up!, o Citigo, que tem uns toques diferentes de estilo - ele usa a janela traseira mais conservadora do VW feito no Brasil.</p> <p> De acordo com o ve&#237;culo, a Skoda desenvolve uma s&#233;rie de ideias para um carro barato para a &#205;ndia que possa ser usado em outros mercados em desenvolvimento, incluindo o Ir&#227; e o Brasil. A informa&#231;&#227;o partiu de Thomas Sedran, chefe de estrat&#233;gia do grupo Volkswagen.</p> <p> Havia at&#233; um plano de projetar o novo carro em conjunto com a indiana Tata, por&#233;m, as negocia&#231;&#245;es falharam. Seria uma jointventure para gerar compactos emergentes tamb&#233;m para outros mercados, mas a Skoda desistiu de usar a plataforma AMP da Tata, algo que poderia gerar problemas para adaptar a estrutura aos par&#226;metros mais exigentes de crashtests e emiss&#245;es.</p> <div class=\"saibamais componente_materia expandido\"> <strong>saiba mais</strong> <ul> <li> <a href=\"http://revistaautoesporte.globo.com/testes/noticia/2017/07/teste-volkswagen-pepper.html\">Teste: o que achamos do Volkswagen up! Pepper, atual vers&#227;o topo de linha do subcompacto&#160;</a></li> <li> <a href=\"http://revistaautoesporte.globo.com/Noticias/noticia/2017/08/volkswagen-revela-t-roc-modelo-que-vem-para-o-brasil.html\">Revelado: Volkswagen apresenta oficialmente o T-Roc, crossover que vir&#225; para o Brasil</a></li> <li> <a href=\"http://revistaautoesporte.globo.com/Analises/noticia/2017/08/primeiras-impressoes-volkswagen-polo-10-tsi.html\">Teste: o que n&#243;s achamos do novo Volkswagen Polo 1.0 TSI nacional no primeiro contato</a></li> </ul> </div> <p> &#160;</p> <p> &#160;</p> <p> &#160;</p> <p> &#160;</p> <p> &#160;</p> <p> &#160;</p> ";

	@Test
	public void deveRetornarUmaListaDeDescripton() {
		List<Description> findElements = elementFindService.find(Optional.of(content));
		Assert.assertEquals(DescriptionType.IMAGE.getType(), findElements.get(0).getType());
		Assert.assertTrue(!findElements.isEmpty());
	}

}
