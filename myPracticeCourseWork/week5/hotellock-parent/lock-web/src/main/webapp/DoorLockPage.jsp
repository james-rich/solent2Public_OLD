<%-- 
    Document   : DoorLockPage.jsp
    Created on : Oct 20, 2018, 6:34:33 PM
    Author     : cgallen
--%>
<%@page import="org.apache.logging.log4j.LogManager"%>
<%@page import="org.apache.logging.log4j.Logger"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.model.SecretKeyProvider"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.model.CardKey"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.model.HotelReceptionService"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.reception.HotelReceptionServiceImpl"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.secretkey.SecretKeyProviderImpl" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HotelReceptionService hotelReceptionService = (HotelReceptionService) session.getAttribute("hotelReceptionService");
    Logger TRANSACTIONLOG = LogManager.getLogger("transaction-log");
    // If the user session has no hotelReceptionService, create a new one
    if (hotelReceptionService == null) {
        hotelReceptionService = new HotelReceptionServiceImpl();
        SecretKeyProvider secretKeyProvider = new SecretKeyProviderImpl();
        hotelReceptionService.setSecretKeyProvider(secretKeyProvider);
        session.setAttribute("hotelReceptionService", hotelReceptionService);
    }


    String roomNumber = (String) request.getParameter("roomNumber");
    if (roomNumber == null) {
        roomNumber = (String) session.getAttribute("sessionRoomNumber");
        if (roomNumber == null) {
            roomNumber = "";
        }
    } else {
        session.setAttribute("sessionRoomNumber", roomNumber);
    }

    String cardCode = (String) request.getParameter("cardCode");
    if (cardCode == null) {
        cardCode = (String) session.getAttribute("sessionCardCode");
        if (cardCode == null) {
            cardCode = "";
        }
    } else {
        session.setAttribute("sessionCardCode", cardCode);
    }

    boolean errorReadingCard = false;
    boolean doorStatus = false;
    if (!cardCode.equals(null) && !roomNumber.equals(null)) {
        try {
            CardKey cardKey = hotelReceptionService.readCard(cardCode);
            if(cardKey.getRoomNumber().equals(roomNumber)){
                TRANSACTIONLOG.info("room number '" + roomNumber + "'  card access successfully opened door: " + cardKey);
                doorStatus = true;
            }
            else{
                doorStatus = false;
            }
        } catch (Exception ex) {
            errorReadingCard = true;
        }
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Door Lock Page</title>
    </head>
    <body>
        <h1>Door Lock</h1>

        <form action="./DoorLockPage.jsp">
            Enter Room Number:<br>
            <input type="text" name="roomNumber" value="<%=roomNumber%>">
            <% if (roomNumber.isEmpty()) { %>
                Room Number must not be empty
            <% }%>
            <br>
            Enter Card Code:<br>
            <input type="text" name="cardCode" value="<%=cardCode%>">
            <% if (cardCode.isEmpty()) { %>
                Room Number must not be empty
            <% }%>
            <br>
            <input type="submit" value="Unlock Door">
        </form> 
        <br>
        <% if (doorStatus) { %>
            <div id="result">
                Door Unlocked
            </div>
        <% } %>
    </body>
</html>
