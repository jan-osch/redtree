<#-- @ftlvariable name="users" type="java.util.List<pl.edu.uj.jg.auth.domain.User>" -->

<#import "skeleton.ftl" as skeleton>
<@skeleton.page title="List of current Users">

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>E-mail</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <td><a href="/user/${user.id}">${user.email}</a></td>
            <td>${user.role}</td>
        </tr>
        </#list>
    </tbody>
</table>
</@skeleton.page>