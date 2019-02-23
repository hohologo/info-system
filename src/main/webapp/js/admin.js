$("#department").change(function () {
    var deptId = $(this).val();
    $.ajax({
        type: "GET",
        url: "/admin/department/" + deptId + "/majors",
        success: function (data) {
            var majors = $('#major');
            var option = "";
            majors.empty();

            for (var i = 0; i < data.length; i++) {
                option = option + "<option value=\"" + data[i].majorId + "\" name=\"major.majorId\">" + data[i].majorName + "</option>";
            }
            majors.append(option);
        },
        error: function () {
            console.log("Error to achieve major information");
        }
    });
});