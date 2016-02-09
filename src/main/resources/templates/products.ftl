<#-- @ftlvariable name="product" type="java.util.List<pl.edu.uj.jg.auth.domain.User>" -->
<#import "skeleton.ftl" as skeleton>
    <@skeleton.page title="List of current Users">
    <h2>Product Details</h2>
<div class="container">
    <div th:if="${not #lists.isEmpty(products)}">
        <h2>Product List</h2>
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Price</th>
                <th>ImageUrl</th>
                <th>List</th>
            </tr>
            <tr th:each="product: ${products}">
                <th th:text="${product.id}"></th>
                <th th:text="${product.description}"></th>
                <th th:text="${product.price}"></th>
                <th th:text="${product.imageUrl}"></th>
                <th ><a th:href="'/product/'+${product.id}">View details</a></th>
            </tr>
        </table>
    </div>

    <a href="/product/new" class="btn btn-default">New Product</a>
</div>