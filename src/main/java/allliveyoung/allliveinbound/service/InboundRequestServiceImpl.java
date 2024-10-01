package allliveyoung.allliveinbound.service;

import allliveyoung.allliveinbound.config.ModelMapperConfig;
import allliveyoung.allliveinbound.domain.InboundRequest;
import allliveyoung.allliveinbound.domain.InboundRequestProduct;
import allliveyoung.allliveinbound.domain.Member;
import allliveyoung.allliveinbound.domain.Warehouse;
import allliveyoung.allliveinbound.mapper.InboundRequestMapper;
import allliveyoung.allliveinbound.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class InboundRequestServiceImpl implements InboundRequestService {

    private final InboundRequestMapper inboundRequestMapper;
    private final ModelMapper modelMapper;

    @Override
    public InboundPageResponseDTO<InboundRequestDTO> findInbounds(InboundPageRequestDTO inboundPageRequestDTO, Member member) {
        List<InboundRequestDTO> requests = inboundRequestMapper.findAll(inboundPageRequestDTO, member).stream()
                .map(request -> modelMapper.map(request,InboundRequestDTO.class)).collect(Collectors.toList());

        int total = inboundRequestMapper.getCount(inboundPageRequestDTO, member);

        InboundPageResponseDTO<InboundRequestDTO> responseDTO = InboundPageResponseDTO.<InboundRequestDTO>withAll()
                .dtoList(requests).total(total).inboundPageRequestDTO(inboundPageRequestDTO).build();

        return responseDTO;
    }

    @Override
    public List<InboundProductDTO> findInbound(Long id) {
        List<InboundRequestProduct> inboundRequestProducts = inboundRequestMapper.findById(id);
        List<InboundProductDTO> inboundProductDTOList = inboundRequestProducts.stream()
                .map(inboundRequestProduct -> modelMapper.map(inboundRequestProduct,InboundProductDTO.class)).collect(Collectors.toList());

        return inboundProductDTOList;
    }

    @Override
    public Long saveInbound(InboundRequestSaveDTO inboundRequestSaveDTO) {
        Long id = inboundRequestMapper.save(inboundRequestSaveDTO);
        inboundRequestMapper.saveProducts(inboundRequestSaveDTO.getInboundProductSaveDTOList());
        return id;
    }

    @Override
    public void updateInbound(Long id, InboundRequestUpdateDTO inboundRequestUpdateDTO) {
        inboundRequestMapper.update(id);
        log.info(inboundRequestUpdateDTO.getInboundProductUpdateDTOList());
        inboundRequestMapper.updateProducts(inboundRequestUpdateDTO.getInboundProductUpdateDTOList());
    }

    @Override
    public void deleteInbound(Long id) {
        inboundRequestMapper.delete(id);
    }

    @Override
    public void updateInboundStatus(Long id, String status) {
        Map map = Map.of("id",id,"status",status);
        inboundRequestMapper.updateStatus(map);
    }

    @Override
    public List<WarehouseDTO> getWarehouseList() {
        List<Warehouse> warehouseList = inboundRequestMapper.getWarehouseList();
        List<WarehouseDTO> warehouseDTOList = warehouseList.stream()
                .map(warehouse -> modelMapper.map(warehouse,WarehouseDTO.class)).collect(Collectors.toList());
        return warehouseDTOList;
    }

    @Override
    public List<ProductDTO> getMatchedProductList(Long id) {
        List<ProductDTO> productDTOList = inboundRequestMapper.getMatchedProductList(id).stream()
                .map(product -> modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
        return productDTOList;
    }

    @Transactional(readOnly = true)
    public Integer getCount(String status) {
        return inboundRequestMapper.countByStatus(status);
    }

    @Transactional(readOnly = true)
    public List<CountRequestDTO> findCountInbound(Integer year) {
        return inboundRequestMapper.findCountInbound(year);
    }

    @Transactional(readOnly = true)
    public List<CountStockDTO> findCountStock(Integer year){
        return inboundRequestMapper.findCountStock(year);
    }
}
