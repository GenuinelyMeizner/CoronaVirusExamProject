updateParishList()

async function updateParishList() {
    const url = "/api/get-all-parishes";
    const response = await fetch(url);
    const data = await response.json();

    console.log(data);

    const tableBody = document.getElementById("table-body");

    data.forEach(parish => {
        const tableRow = document.createElement("tr");
        tableBody.appendChild(tableRow);

        const parishName = document.createElement("td");
        parishName.textContent = parish.parishName;
        tableRow.appendChild(parishName);

        const parishCode = document.createElement("td");
        parishCode.textContent = parish.parishCode;
        tableRow.appendChild(parishCode);

        const infectionPercentage = document.createElement("td");
        infectionPercentage.textContent = parish.infectionPercentage;
        tableRow.appendChild(infectionPercentage);
    })
}