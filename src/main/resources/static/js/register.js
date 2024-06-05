document.getElementById('registerForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const surName = document.getElementById('surName').value;
    const lastName = document.getElementById('lastName').value;
    const patronymic = document.getElementById('patronymic').value;

    const userData = {
        surName,
        lastName,
        patronymic
    };

    try {
        const response = await fetch('/api/v2/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });

        if (response.ok) {
            window.location.href = '/api/v2';
        } else {
            const errorData = await response.json();
            console.error('Error:', errorData);
        }
    } catch (error) {
        console.log('Error submitting form:', error);
    }
});