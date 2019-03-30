package openwebinar.marvel.app.resource;

import openwebinar.marvel.app.domain.Avenger;
import openwebinar.marvel.app.dto.AvengerDTO;
import openwebinar.marvel.app.services.AvengerService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("avengers")
public class AvengerController {

    private final Log log = LogFactory.getLog(AvengerController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AvengerService avengerService;


    @GetMapping("/countAll")
    public Long countAll() {
        log.info("countAll");
        return avengerService.countAllByIdGreaterThanEqual(0L);
    }

    @GetMapping("/get/{id}")
    public AvengerDTO getAvengerById(@PathVariable Long id) {
        log.info("getAvengerById");
        Avenger avenger = avengerService.findById(id);

        return convertToDto(avenger);
    }

    @GetMapping("/getName/{lang}/{name}")
    public AvengerDTO getAvengerByNameAndLang(@PathVariable String lang, @PathVariable String name) {
        log.info("getAvengerByNameAndLang");
        Avenger avenger = avengerService.findByNameAndLang(name, lang);

        return convertToDto(avenger);
    }

    @GetMapping("/getActor/{lang}/{actor}")
    public AvengerDTO getAvengerByActorAndLang(@PathVariable String lang, @PathVariable String actor) {
        log.info("getAvengerByNameAndLang");
        Avenger avenger = avengerService.findByActorAndLang(actor, lang);

        return convertToDto(avenger);
    }

    @GetMapping("/getAll")
    public List<AvengerDTO> getAll() {
        log.info("getAll");
        List<Avenger> avengers = avengerService.findAll();

        return convertToDto(avengers);
    }

    @GetMapping("/getAll/{lang}")
    public List<AvengerDTO> getAllByLang(@PathVariable String lang) {
        log.info("getAllByLang");
        List<Avenger> avengers = avengerService.findByLang(lang);

        return convertToDto(avengers);
    }

    @PostMapping("/setAvenger")
    public AvengerDTO addAvenger(@RequestBody AvengerDTO newAvenger) {
        log.info("addAvenger");
        Avenger newAvengerEntity = convertToEntity(newAvenger);
        Avenger avenger = avengerService.save(newAvengerEntity);

        return convertToDto(avenger);
    }

    @PutMapping("/change/{id}")
    public AvengerDTO replaceAvenger(@RequestBody AvengerDTO newAvenger, @PathVariable Long id) {
        log.info("replaceAvenger");
        Avenger avenger = avengerService.findById(id);
        Avenger updateAvenger;
        if (avenger != null) {
            if (newAvenger.getName() != null) avenger.setName(newAvenger.getName());
            if (newAvenger.getActor() != null) avenger.setActor(newAvenger.getActor());
            if (newAvenger.getDescription() != null) avenger.setDescription(newAvenger.getDescription());
            if (newAvenger.getLang() != null) avenger.setLang(newAvenger.getLang());
            if (newAvenger.getUrlimage() != null) avenger.setUrlimage(newAvenger.getUrlimage());
            updateAvenger = avengerService.save(avenger);
        } else {
            newAvenger.setId(id);
            Avenger newAvengerEntity = convertToEntity(newAvenger);
            updateAvenger = avengerService.save(newAvengerEntity);
        }

        return convertToDto(updateAvenger);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAvenger(@PathVariable Long id) {
        log.info("deleteAvenger: id=" + id);
        avengerService.deleteById(id);

    }


    private AvengerDTO convertToDto(Avenger avenger) {
        if (avenger != null) {
            return modelMapper.map(avenger, AvengerDTO.class);
        } else {
            return null;
        }
    }

    private List<AvengerDTO> convertToDto(List<Avenger> avenger) {
        if (avenger != null) {
            Type listType = new TypeToken<List<AvengerDTO>>() {}.getType();
            return modelMapper.map(avenger, listType);
        } else {
            return null;
        }
    }

    private Avenger convertToEntity(AvengerDTO avenger) {
        if (avenger != null) {
            return modelMapper.map(avenger, Avenger.class);
        } else {
            return null;
        }
    }

}
