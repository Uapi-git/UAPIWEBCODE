/**
 * Test Script Name                      : IAutoConst.
 * Objective                             : Used to handle constant paths in entire project
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 06/06/2024
 * Last Updated on                       : N/A
 * Updated By                            :
 * Epic Details                          : N/A
 * User Story Details                    : N/A
 * Defects affecting this test script    : None
 * Work Around/Known Issues              : None
 **/
package com.azmqalabs.uapitestautomation.common;

import java.nio.file.Paths;

public interface IAutoConst {

    String ENV_ATTACHMENT_PATH = System.getProperty("user.dir") + "//Attachments//";
    String userHome = System.getProperty("user.home");
    String downloadsPath = Paths.get(userHome, "Downloads").toString();
    String ENV_DOWNLOADS_RESOURCE_PATH = downloadsPath;

}