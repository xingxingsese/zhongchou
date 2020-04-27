<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="${ctx}/static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/font-awesome.min.css">
<link rel="stylesheet" href="${ctx}/static/css/main.css">
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}

table tbody tr:nth-child(odd) {
	background: #F4F4F4;
}

table tbody td:nth-child(even) {
	color: #C00;
}
</style>
</head>

<body>

	<%pageContext.setAttribute("title", "项目分类");%>
			<!--顶部导航  -->
			<%@ include file="/include/top-nav.jsp"%>

			<div class="container-fluid">
				<div class="row">


					<%@ include file="/include/side-bar.jsp"%>
					<div
						class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="glyphicon glyphicon-th"></i> 数据列表
								</h3>
							</div>
							<div class="panel-body">
								<form class="form-inline" role="form" style="float: left;">
									<div class="form-group has-feedback">
										<div class="input-group">
											<div class="input-group-addon">查询条件</div>
											<input class="form-control has-success" type="text"
												placeholder="请输入查询条件">
										</div>
									</div>
									<button type="button" class="btn btn-warning">
										<i class="glyphicon glyphicon-search"></i> 查询
									</button>
								</form>
								<button type="button" class="btn btn-danger"
									style="float: right; margin-left: 10px;">
									<i class=" glyphicon glyphicon-remove"></i> 删除
								</button>
								<button type="button" class="btn btn-primary"
									style="float: right;"
									onclick="window.location.href='form.html'">
									<i class="glyphicon glyphicon-plus"></i> 新增
								</button>
								<br>
								<hr style="clear: both;">
								<div class="table-responsive">
									<table class="table  table-bordered">
										<thead>
											<tr>
												<th width="30">#</th>
												<th width="30"><input type="checkbox"></th>
												<th width="300">分类名称</th>
												<th>简介</th>
												<th width="100">操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td><input type="checkbox"></td>
												<td>科技</td>
												<td>xxxxx</td>
												<td>
													<button type="button" class="btn btn-primary btn-xs">
														<i class=" glyphicon glyphicon-pencil"></i>
													</button>
													<button type="button" class="btn btn-danger btn-xs">
														<i class=" glyphicon glyphicon-remove"></i>
													</button>
												</td>
											</tr>
											<tr>
												<td>2</td>
												<td><input type="checkbox"></td>
												<td>农业</td>
												<td>xxxxx</td>
												<td>
													<button type="button" class="btn btn-primary btn-xs">
														<i class=" glyphicon glyphicon-pencil"></i>
													</button>
													<button type="button" class="btn btn-danger btn-xs">
														<i class=" glyphicon glyphicon-remove"></i>
													</button>
												</td>
											</tr>
											<tr>
												<td>3</td>
												<td><input type="checkbox"></td>
												<td>电子</td>
												<td>xxxxx</td>
												<td>
													<button type="button" class="btn btn-primary btn-xs">
														<i class=" glyphicon glyphicon-pencil"></i>
													</button>
													<button type="button" class="btn btn-danger btn-xs">
														<i class=" glyphicon glyphicon-remove"></i>
													</button>
												</td>
											</tr>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			
	<%@ include file="/include/common-js.jsp" %>
</body>
</html>
