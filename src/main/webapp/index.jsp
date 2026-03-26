<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.alkawallet.model.Wallet" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>AlkaWallet - Mi Billetera</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .wallet-card { max-width: 500px; margin: 50px auto; padding: 20px; border-radius: 15px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); background-color: white; }
        .balance-display { font-size: 2.5rem; font-weight: bold; color: #198754; text-align: center; margin: 20px 0; }
    </style>
</head>
<body>

<div class="container">
    <div class="wallet-card">
        <h2 class="text-center">AlkaWallet</h2>
        <hr>

        <%
            Wallet wallet = (Wallet) session.getAttribute("wallet");
            if (wallet == null) {
                // Redirect to Servlet to initialize session
                response.sendRedirect("wallet");
                return;
            }
        %>

        <div class="balance-display">
            $ <%= String.format("%.2f", wallet.getBalance()) %>
        </div>
        <p class="text-center text-muted">Saldo Disponible</p>

        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <form action="wallet" method="post" class="mt-4">
            <div class="mb-3">
                <label for="amount" class="form-label">Monto</label>
                <input type="number" step="0.01" class="form-control" id="amount" name="amount" required min="0.01">
            </div>
            <div class="d-grid gap-2 d-md-block text-center">
                <button type="submit" name="action" value="deposit" class="btn btn-success px-4">Depositar</button>
                <button type="submit" name="action" value="withdraw" class="btn btn-danger px-4">Retirar</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
