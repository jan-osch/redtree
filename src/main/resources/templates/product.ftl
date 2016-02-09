<#-- @ftlvariable name="product" type="java.util.List<pl.edu.uj.jg.auth.domain.User>" -->
<#import "skeleton.ftl" as skeleton>
<@skeleton.page title="List of current Users">
<h2>Product Details</h2>
<div>
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">Product Id:</label>
            <div class="col-sm-10">
                <p class="form-control-static" text="${product.id}">Product Id</p></div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Description:</label>
            <div class="col-sm-10">
                <p class="form-control-static" text="${product.description}">description</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Price:</label>
            <div class="col-sm-10">
                <p class="form-control-static" text="${product.price}">Priceaddd</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Image Url:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${product.imageUrl}</p>
            </div>
        </div>
    </form>
</div>
<a href="'/product/edit/'+ ${product.id}" class="btn btn-default">Edit Product</a>
<a href="'/product/delete/'+ ${product.id}" class="btn btn-default">Delete Product</a>
</@skeleton.page>



