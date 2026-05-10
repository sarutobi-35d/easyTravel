function nextStep(step) {
    // Une petite validation rapide côté client pour l'étape 1
    if (step === 2) {
        const agenceName = document.querySelector('input[name="nameAgence"]').value;
        const siege = document.querySelector('input[name="siegeSocial"]').value;

        if (!agenceName || !siege) {
            alert("Veuillez remplir les informations de l'agence avant de continuer.");
            return;
        }
    }

    // On cache toutes les étapes et on affiche la nouvelle
    document.querySelectorAll('.form-step').forEach(el => el.classList.remove('active'));
    document.getElementById('form-step-' + step).classList.add('active');

    updateStepper(step);
}

function prevStep(step) {
    document.querySelectorAll('.form-step').forEach(el => el.classList.remove('active'));
    document.getElementById('form-step-' + step).classList.add('active');
    updateStepper(step);
}

function updateStepper(step) {
    // On réinitialise l'apparence des cercles et des lignes
    for(let i = 1; i <= 3; i++) {
        document.getElementById('step-i-' + i).classList.remove('active');
        if(i < 3) document.getElementById('line-' + i).classList.remove('active');
    }

    // On active visuellement jusqu'à l'étape actuelle
    for(let i = 1; i <= step; i++) {
        document.getElementById('step-i-' + i).classList.add('active');
        if(i < step) document.getElementById('line-' + i).classList.add('active');
    }
}