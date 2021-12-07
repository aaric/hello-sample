/**
 * (c) Copyright Ascensio System SIA 2021
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.onlyoffice.integration.services.configurers.implementations;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import com.onlyoffice.integration.documentserver.managers.document.DocumentManager;
import com.onlyoffice.integration.documentserver.managers.template.TemplateManager;
import com.onlyoffice.integration.documentserver.models.enums.Action;
import com.onlyoffice.integration.documentserver.models.enums.Mode;
import com.onlyoffice.integration.documentserver.models.filemodel.EditorConfig;
import com.onlyoffice.integration.documentserver.util.file.FileUtility;
import com.onlyoffice.integration.entities.User;
import com.onlyoffice.integration.mappers.Mapper;
import com.onlyoffice.integration.services.configurers.EditorConfigConfigurer;
import com.onlyoffice.integration.services.configurers.wrappers.DefaultCustomizationWrapper;
import com.onlyoffice.integration.services.configurers.wrappers.DefaultEmbeddedWrapper;
import com.onlyoffice.integration.services.configurers.wrappers.DefaultFileWrapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Primary
public class DefaultEditorConfigConfigurer implements EditorConfigConfigurer<DefaultFileWrapper> {

    @Autowired
    private Mapper<User, com.onlyoffice.integration.documentserver.models.filemodel.User> mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    @Qualifier("sample")
    private TemplateManager templateManager;

    @Autowired
    private DefaultCustomizationConfigurer defaultCustomizationConfigurer;

    @Autowired
    private DefaultEmbeddedConfigurer defaultEmbeddedConfigurer;

    @Autowired
    private FileUtility fileUtility;

    @Override
    @SneakyThrows
    public void configure(EditorConfig config, DefaultFileWrapper wrapper) {
        if (wrapper.getActionData() != null) {
            config.setActionLink(objectMapper.readValue(wrapper.getActionData(), (JavaType) new TypeToken<HashMap<String, Object>>() {
            }.getType()));
        }
        String fileName = wrapper.getFileName();

        config.setTemplates(templateManager.createTemplates(fileName));
        config.setCallbackUrl(documentManager.getCallback(fileName));
        config.setCreateUrl(documentManager.getCreateUrl(fileName, false));
        config.setLang(wrapper.getLang());
        Boolean canEdit = fileUtility.getEditedExts().contains(fileUtility.getFileExtension(fileName));
        Action action = wrapper.getAction();

        defaultCustomizationConfigurer.configure(config.getCustomization(), DefaultCustomizationWrapper.builder()
                .action(action)
                .canEdit(canEdit)
                .build());
        config.setMode(canEdit && !action.equals(Action.view) ? Mode.edit : Mode.view);
        config.setUser(mapper.toModel(wrapper.getUser()));
        defaultEmbeddedConfigurer.configure(config.getEmbedded(), DefaultEmbeddedWrapper.builder()
                .type(wrapper.getType())
                .fileName(fileName)
                .build());
    }
}
