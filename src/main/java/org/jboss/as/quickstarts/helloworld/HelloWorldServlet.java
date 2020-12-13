/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * <p>
 * A simple servlet taking advantage of features added in 3.0.
 * </p>
 * 
 * <p>
 * The servlet is registered and mapped to /HelloServlet using the {@linkplain WebServlet
 * @HttpServlet}. The {@link HelloService} is injected by CDI.
 * </p>
 * 
 * @author Pete Muir
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/get_RsaSecret")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("ReturnCode", "0000");
        obj.put("ReturnMsg", "Loading RSA public key loaded.");
        obj.put("RsaSecret", "30820122300D06092A864886F70D01010105000382010F003082010A0282010100C2DC919F7A10776F6A566BBA64E264AA55E14EDFE97990F08441EF8B96F688878BEC11E3E3AE6BE986B248DA64A85B70FEFBC38387FEFFB970BDD73C8A32CA699436EC4797FD727DA8DA2DED25D36C6225001F5DAF56599693D3B708EA1AB12C850A4B2780F65F926CB5DF0F1665BC2A20050CF8337156B0F66D85319987D89365E711ED706235AEBE5A7D859F8992F83839A71383452F54D7315DF242DCCEFDBE97A5D417D052066A2B04F695B7160F127A90C649E39C580CC4CE54E26A158A94590A9128FAA84E0B42F1BDB77F7B564523849851B585DCCFCC12270915175EAD0EE92573D7C7CA37B911C9ACF7A24F066DC6F2CFA25DAF981311CBECF16EDF0203010001");
        out.print(obj.toString());
        out.close();
    }

}
