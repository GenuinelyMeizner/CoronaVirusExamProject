updateParishList()

async function updateParishList() {
    const url = "/api/get-all-parishes";
    const response = await fetch(url);
    const data = await response.json();

    const tableBody = document.getElementById("table-body");

    data.forEach(parish => {
        const tableRow = document.createElement("tr");
        tableBody.appendChild(tableRow);

        const parishName = document.createElement("td");
        parishName.textContent = parish.parishName;
        parishName.contentEditable = true;
        tableRow.appendChild(parishName);

        const parishCode = document.createElement("td");
        parishCode.textContent = parish.parishCode;
        tableRow.appendChild(parishCode);

        const parishInhabitants = document.createElement("td");
        parishInhabitants.textContent = parish.parishInhabitants;
        tableRow.appendChild(parishInhabitants);

        const parishNumberOfIncidents = document.createElement("td");
        parishNumberOfIncidents.textContent = parish.parishNumberOfIncidents;
        tableRow.appendChild(parishNumberOfIncidents);

        const parishNumberOfNewInfected = document.createElement("td");
        parishNumberOfNewInfected.textContent = parish.parishNumberOfNewInfected;
        tableRow.appendChild(parishNumberOfNewInfected);

        const parishPercentageOfInfected = document.createElement("td");
        parishPercentageOfInfected.textContent = parish.parishPercentageOfInfected;
        tableRow.appendChild(parishPercentageOfInfected);

        const parishUnderAutomaticLockdown = document.createElement("td");
        tableRow.appendChild(parishUnderAutomaticLockdown);

        const lockdownCheckBox = document.createElement("input");
        lockdownCheckBox.setAttribute("class", "form-check input");
        lockdownCheckBox.setAttribute("type", "checkbox");
        if(parish.parishUnderAutomaticLockdown === true) {
            lockdownCheckBox.checked = true;
        }
        console.log(parish.parishUnderAutomaticLockdown);
        lockdownCheckBox.disabled = true;
        parishUnderAutomaticLockdown.appendChild(lockdownCheckBox);


        const parishDateOfAutomaticLockdown = document.createElement("td");
        parishDateOfAutomaticLockdown.textContent = parish.parishDateOfAutomaticLockdown;
        tableRow.appendChild(parishDateOfAutomaticLockdown);

        const updateParishContainer = document.createElement("td");
        updateParishContainer.setAttribute("class", "text-center");
        tableRow.appendChild(updateParishContainer);

        const updateButton = document.createElement("button");
        updateButton.setAttribute("type", "button");
        updateButton.setAttribute("class", "btn btn-info");
        updateButton.setAttribute("onclick", "updateParish(this)");
        updateButton.textContent = "Update";
        updateParishContainer.appendChild(updateButton);

        const deleteParishContainer = document.createElement("td");
        deleteParishContainer.setAttribute("class", "text-center");
        tableRow.appendChild(deleteParishContainer);

        const deleteButton = document.createElement("button");
        deleteButton.setAttribute("type", "button");
        deleteButton.setAttribute("class", "btn btn-danger");
        deleteButton.setAttribute("onclick", "");
        deleteButton.textContent = "Delete";
        deleteParishContainer.appendChild(deleteButton);
    });
}