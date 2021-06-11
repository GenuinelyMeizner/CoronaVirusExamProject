updateParishList()

/**
 * Fetches a list of all parishes and displays them dynamically on index.html
 */

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

/**
 * This method has no HTML/CSS supporting it and is therefore just a showcase of my CRUD Create ability
 * Feel free to try the method out by calling it at the top of this file
 * Creates a Parish and Municipality object and inserts them into the database
 */

function createParish() {

    const parishObject = {
        "parishName": "Rud",
        "parishCode": 8144,
        "parishInhabitants": 314,
        "parishNumberOfIncidents": 955.41,
        "parishNumberOfNewInfected": 3,
        "parishPercentageOfInfected": 7.69,
        "parishUnderAutomaticLockdown": false,
        "parishDateOfAutomaticLockdown": null,
        "municipality": {
            "municipalityName": "Favrskov",
            "municipalityCode": 710
        }
    }
    const parishBody = JSON.stringify(parishObject);

    const insertParishUrl = "/api/create-parish";

    const requestObject = {
        headers:{
            'Content-Type':'application/json',
        },
        method:'POST',
        body: parishBody
    };

    fetch(insertParishUrl, requestObject)
        .then(response => response.json());
}

/**
 * This method has no HTML/CSS supporting it and is therefore just a showcase of my CRUD Update ability
 * Feel free to try the method out by calling it at the top of this file
 * Updates the entry in the database based on a @PathVariable
 */

function updateParish() {
    const parishObject = {
        "parishId": 2,
        "parishName": "Budfolfi - This has just been updated",
        "parishCode": 8364,
        "parishInhabitants": 7216,
        "parishNumberOfIncidents": 706.76,
        "parishNumberOfNewInfected": 51,
        "parishPercentageOfInfected": 3.11,
        "parishUnderAutomaticLockdown": true,
        "parishDateOfAutomaticLockdown": "2021-05-30",
        "municipality": {
            "municipalityId": 2,
            "municipalityName": "Aalborg",
            "municipalityCode": 851
        }
    }
    const parishBody = JSON.stringify(parishObject);

    const putParishUrl = "/api/update-parish/2";

    const requestObject = {
        headers:{
            'Content-Type':'application/json',
        },
        method:'PUT',
        body: parishBody
    };

    fetch(putParishUrl, requestObject)
        .then(response => response.json());
}

/**
 * This method has no HTML/CSS supporting it and is therefore just a showcase of my CRUD Delete ability
 * Feel free to try the method out by calling it at the top of this file
 * Deletes an entry from the database based on a @PathVariable
 */

function deleteParish() {
    const deleteParishUrl = "/api/delete-parish/3";

    const deleteObject = {
        method:'DELETE'
    }
    fetch(deleteParishUrl, deleteObject)
}