package com.test.senior.modules.pedido.controller;

import com.test.senior.modules.pedido.dto.CreatePedidoDto;
import com.test.senior.modules.pedido.dto.PedidoDto;
import com.test.senior.modules.pedido.dto.PedidoFilter;
import com.test.senior.modules.pedido.service.PedidoService;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/pedido")
public class PedidoController {

  private PedidoService pedidoService;

  @GetMapping("/{idPedido}")
  public PedidoDto findById(@PathVariable UUID idPedido) {
    return pedidoService.findById(idPedido);
  }

  @PostMapping()
  public PedidoDto create(@RequestBody CreatePedidoDto dto) {
    return pedidoService.create(dto);
  }

  @PutMapping("{idPedido}/finish")
  public void finalizarPedido(@PathVariable UUID idPedido) {
    pedidoService.finalizarPedido(idPedido);
  }

  @PutMapping("{idPedido}/apply-desc")
  public void applyDesc(@PathVariable UUID idPedido, @RequestParam BigDecimal vlDesc) {
    pedidoService.applyDesc(idPedido, vlDesc);
  }

  @GetMapping
  public Page<PedidoDto> findAll(PedidoFilter filter, Pageable pageable) {
    return pedidoService.findAll(filter, pageable);
  }

  @DeleteMapping("/{idPedido}/delete")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable UUID idPedido) {
    pedidoService.deleteById(idPedido);
  }
}
