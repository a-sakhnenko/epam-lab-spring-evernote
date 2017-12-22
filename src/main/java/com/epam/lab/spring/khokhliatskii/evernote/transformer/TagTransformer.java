package com.epam.lab.spring.khokhliatskii.evernote.transformer;

import com.epam.lab.spring.khokhliatskii.evernote.dto.TagDto;
import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagTransformer implements Transformer<Tag, TagDto> {

    @Autowired
    private TagService tagService;

    @Override
    public TagDto unbind(Tag source) {
        TagDto tagDto = new TagDto();
        tagDto.setId(source.getId());
        tagDto.setName(source.getName());
        return tagDto;
    }

    @Override
    public Tag bind(TagDto source) {
        Tag tag = tagService.findById(source.getId());
        if (tag == null) {
            tag = new Tag();
        }
        tag.setName(source.getName());
        return tag;
    }
}
