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

package com.onlyoffice.integration.controllers;

import com.onlyoffice.integration.documentserver.storage.FileStorageMutator;
import com.onlyoffice.integration.documentserver.storage.FileStoragePathBuilder;
import com.onlyoffice.integration.documentserver.util.Misc;
import com.onlyoffice.integration.documentserver.util.file.FileUtility;
import com.onlyoffice.integration.entities.User;
import com.onlyoffice.integration.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@Controller
public class IndexController {

    @Autowired
    private FileStorageMutator storageMutator;

    @Autowired
    private FileStoragePathBuilder storagePathBuilder;

    @Autowired
    private FileUtility fileUtility;

    @Autowired
    private Misc mistUtility;

    @Autowired
    private UserServices userService;

    @Value("${files.docservice.url.site}")
    private String docserviceSite;

    @Value("${files.docservice.url.preloader}")
    private String docservicePreloader;

    @Value("${url.converter}")
    private String urlConverter;

    @Value("${url.editor}")
    private String urlEditor;

    @GetMapping("${url.index}")
    public String index(Model model) {
        File[] files = storageMutator.getStoredFiles();
        List<String> docTypes = new ArrayList<>();
        List<Boolean> filesEditable = new ArrayList<>();
        List<String> versions = new ArrayList<>();

        List<User> users = userService.findAll();

        String tooltip = users.stream()
                .map(user -> mistUtility.convertUserDescriptions(user.getName(), user.getDescriptions()))
                .collect(Collectors.joining());

        for (File file : files) {
            String fileName = file.getName();
            docTypes.add(fileUtility.getDocumentType(fileName).toString().toLowerCase());
            filesEditable.add(fileUtility.getEditedExts().contains(fileUtility.getFileExtension(fileName)));
            versions.add(" [" + storagePathBuilder.getFileVersion(fileName, true) + "]");
        }

        model.addAttribute("versions", versions);
        model.addAttribute("files", files);
        model.addAttribute("docTypes", docTypes);
        model.addAttribute("filesEditable", filesEditable);
        model.addAttribute("datadocs", docserviceSite + docservicePreloader);
        model.addAttribute("tooltip", tooltip);
        model.addAttribute("users", users);

        return "index.html";
    }

    @PostMapping("/config")
    @ResponseBody
    public HashMap<String, String> configParameters() {
        HashMap<String, String> configuration = new HashMap<>();

        configuration.put("ConverExtList", String.join(",", fileUtility.getConvertExts()));
        configuration.put("EditedExtList", String.join(",", fileUtility.getEditedExts()));
        configuration.put("UrlConverter", urlConverter);
        configuration.put("UrlEditor", urlEditor);

        return configuration;
    }
}
