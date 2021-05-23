package com.test.senior.modules.produto.service.impl;

import com.test.senior.exception.RecordNotFoundException;
import com.test.senior.handler.BusinessException;
import com.test.senior.helper.i18n.Translator;
import com.test.senior.modules.pedido.service.PedidoItemService;
import com.test.senior.modules.produto.dto.CreateProdutoDto;
import com.test.senior.modules.produto.dto.ProdutoDto;
import com.test.senior.modules.produto.dto.ProdutoFilter;
import com.test.senior.modules.produto.mapper.ProdutoMapper;
import com.test.senior.modules.produto.repository.ProdutoRepository;
import com.test.senior.modules.produto.service.ProdutoService;
import java.util.Date;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseStatus;

@Validated
@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {
  private final ProdutoRepository produtoRepository;
  private final ProdutoMapper produtoMapper;
  private final PedidoItemService pedidoItemService;
  private final Translator translator;

  @Override
  public ProdutoDto findById(UUID idProduto) {
    var produto = produtoRepository.findById(idProduto).orElseThrow(RecordNotFoundException::new);
    return produtoMapper.toProdutoDto(produto);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<ProdutoDto> findAll(ProdutoFilter filter, Pageable pageable) {
    return produtoRepository.findAll(filter, pageable).map(produtoMapper::toProdutoDto);
  }

  @Override
  public void deleteById(UUID idProduto) {
    validaSeExistemProdutosEmPedido(idProduto);
    produtoRepository.deleteById(idProduto);
  }

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  public UUID create(@Valid CreateProdutoDto dto) {
    var produto = produtoMapper.toProduto(dto);
    produto.setDtCadastro(new Date());
    return produtoRepository.save(produto).getId();
  }

  @Override
  public void update(UUID idProduto, CreateProdutoDto dto) {
    produtoRepository.findById(idProduto).orElseThrow(RecordNotFoundException::new);

    var produto = produtoMapper.toProduto(dto);
    produto.setId(idProduto);

    produtoRepository.save(produto);
  }

  private void validaSeExistemProdutosEmPedido(UUID idProduto) {
    var existsInPedido = pedidoItemService.existsItemInPedido(idProduto);

    if (existsInPedido) {
      throw new BusinessException(translator.get("nao.eh.possivel.deletar.produto.em.pedido"));
    }
  }
}
