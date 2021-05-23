package com.test.senior.modules.pedido.controller;

import com.test.senior.modules.pedido.dto.PedidoItemDto;
import com.test.senior.modules.pedido.service.PedidoItemService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/pedido-item")
public class PedidoItemController {

  private final PedidoItemService pedidoItemService;

  @PostMapping()
  public UUID create(@RequestBody PedidoItemDto dto) {
    return pedidoItemService.createItem(dto);
  }

  @PostMapping("/batch")
  public List<PedidoItemDto> batchCreate(@RequestBody List<PedidoItemDto> dto) {
    return pedidoItemService.createItens(dto);
  }
}
