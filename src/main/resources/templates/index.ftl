<#-- @ftlvariable name="products" type="java.util.List<pl.edu.uj.jg.catalogue.domain.products.Product>" -->
<#-- @ftlvariable name="categories" type="java.util.List<pl.edu.uj.jg.catalogue.domain.products.Category>" -->
<#import "skeleton.ftl" as skeleton>
<@skeleton.page title="Home">
    <#list products as product>
        <@skeleton.productshort product=product>

        </@skeleton.productshort>
    </#list >

    <#list categories as category>
    <p>${category.name}</p>
    </#list >

</@skeleton.page>