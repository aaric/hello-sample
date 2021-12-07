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

package com.onlyoffice.integration;

import com.onlyoffice.integration.documentserver.serializers.FilterState;
import com.onlyoffice.integration.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ExampleData {
    @Autowired
    private UserServices userService;

    @PostConstruct
    public void init() {
        List<String> description_user_0 = Arrays.asList(
                "The name is requested when the editor is opened",
                "Doesn’t belong to any group",
                "Can review all the changes",
                "Can perform all actions with comments",
                "The file favorite state is undefined",
                "Can't mention others in comments",
                "Can't create new files from the editor"
        );
        List<String> description_user_1 = Arrays.asList(
                "File author by default",
                "He doesn’t belong to any of the groups",
                "He can review all the changes",
                "He can do everything with the comments",
                "The file favorite state is undefined",
                "Can create a file from a template with data from the editor"
        );
        List<String> description_user_2 = Arrays.asList(
                "He belongs to Group2",
                "He can review only his own changes or the changes made by the users who don’t belong to any of the groups",
                "He can view every comment, edit his comments and the comments left by the users who don't belong to any of the groups and remove only his comments",
                "This file is favorite",
                "Can create a file from an editor"
        );
        List<String> description_user_3 = Arrays.asList(
                "He belongs to Group3",
                "He can review only the changes made by the users from Group2",
                "He can view the comments left by the users from Group2 and Group3 and edit the comments left by the users from Group2",
                "This file isn’t favorite",
                "He can’t copy data from the file into the clipboard",
                "He can’t download the file",
                "He can’t print the file",
                "Can create a file from an editor"
        );
        userService.createUser("John Smith", "smith@example.com",
                description_user_1, null, Arrays.asList(FilterState.NULL.toString()),
                Arrays.asList(FilterState.NULL.toString()),
                Arrays.asList(FilterState.NULL.toString()),
                Arrays.asList(FilterState.NULL.toString()));
        userService.createUser("Mark Pottato", "pottato@example.com",
                description_user_2, "group-2", Arrays.asList("", "group-2"), Arrays.asList(FilterState.NULL.toString()),
                Arrays.asList("group-2", ""), Arrays.asList("group-2"));
        userService.createUser("Hamish Mitchell", "mitchell@example.com",
                description_user_3, "group-3", Arrays.asList("group-2"), Arrays.asList("group-2", "group-3"),
                Arrays.asList("group-2"), new ArrayList<>());
        userService.createUser("Anonymous", null,
                description_user_0, null, Arrays.asList(FilterState.NULL.toString()), Arrays.asList(FilterState.NULL.toString()),
                Arrays.asList(FilterState.NULL.toString()), Arrays.asList(FilterState.NULL.toString()));
    }
}
