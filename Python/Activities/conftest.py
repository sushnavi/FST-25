import pytest

# Create fixture for Activity 23
@pytest.fixture
def num_list():

    # Create list
    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    
    # Alternatively
    # list = list(range(11))

    return list

	
# Define a fixture for the wallet amount for Activity 24
	
@pytest.fixture
	
def wallet_amount():
	
   amount = 0
	
   return amount
