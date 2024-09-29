package allliveyoung.allliveinbound.web.controller;

import allliveyoung.allliveinbound.service.InboundRequestService;
import allliveyoung.allliveinbound.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/inbound-requests")
@Log4j2
@RequiredArgsConstructor
public class InboundRequestController {

    private final InboundRequestService inboundRequestService;

    @GetMapping
    public String getInboundRequests(@RequestParam(required = false) List<String> types, @Validated InboundPageRequestDTO inboundPageRequestDTO, BindingResult bindingResult, Model model) {
        log.info(inboundPageRequestDTO);
        if(bindingResult.hasErrors()) {
            inboundPageRequestDTO = InboundPageRequestDTO.builder().build();
        }
        inboundPageRequestDTO.setTypes(types);

        model.addAttribute("responseDTO", inboundRequestService.findInbounds(inboundPageRequestDTO));
        return null;
    }

    @GetMapping("/{id}")
    public String getInboundRequest(Long id, Model model, InboundPageRequestDTO inboundPageRequestDTO) {
        log.info(id);
        model.addAttribute("inboundRequest", inboundRequestService.findInbound(id));

        return null;
    }

    @GetMapping("/save")
    public String getInboundRequestSaveForm() {
        log.info("getInboundRequestSaveForm..........");

        return null;
    }

    @PostMapping("/save")
    public String postInboundRequestSaveForm(@Validated InboundRequestSaveDTO inboundRequestSaveDTO, @Validated List<InboundProductSaveDTO> inboundProductSaveDTOS, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("has error..........");
            redirectAttributes.addFlashAttribute("error",bindingResult.getAllErrors());
        }

        inboundRequestService.saveInbound(inboundRequestSaveDTO, inboundProductSaveDTOS);

        return "redirect:/inbound-requests/{id}";
    }

    @PostMapping( "/{id}/delete")
    public String postInboundRequestDelete(Long id, InboundPageRequestDTO inboundPageRequestDTO, RedirectAttributes redirectAttributes) {
        log.info("delete..........");
        inboundRequestService.deleteInbound(id);

        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("size", inboundPageRequestDTO.getSize());

        return "redirect:/inbound-requests";
    }

    @PostMapping("/{id}/update")
    public String postInboundRequestUpdateForm(@Validated InboundRequestUpdateDTO inboundRequestUpdateDTO, List<InboundProductUpdateDTO> inboundProductUpdateDTO, InboundPageRequestDTO inboundPageRequestDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("has error..........");
            redirectAttributes.addFlashAttribute("error",bindingResult.getAllErrors());
        }

        inboundRequestService.updateInbound(inboundRequestUpdateDTO, inboundProductUpdateDTO);

        return "redirect:/inbound-requests/{id}";
    }

    @PostMapping("/{id}/update-status")
    public String PostRequestUpdateStatus(Long id, String status, RedirectAttributes redirectAttributes) {
        log.info("update status..........");
        inboundRequestService.updateInboundStatus(id, status);

        return "redirect:/inbound-requests/{id}";
    }
}
