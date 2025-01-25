
# mac-system-metrics

A Python script to fetch and display system performance metrics on macOS devices. This lightweight script provides insights into CPU, memory, disk usage, and detailed system information such as macOS version, uptime, and kernel version.

---

## Features

- **CPU Usage**: Displays the current CPU utilization percentage.
- **Memory Usage**: Shows total, used, free memory, and percentage usage.
- **Disk Usage**: Provides total, used, free disk space, and percentage usage.
- **System Information**: Outputs detailed macOS info, uptime, load averages, kernel version, and more.

---

## Prerequisites

### Software Requirements

1. **Python 3.x**: Ensure Python is installed on your macOS device.
   - Check if Python is installed:
     ```bash
     python3 --version
     ```
   - If not installed, use `brew` to install:
     ```bash
     brew install python3
     ```

2. **Required Python Libraries**:
   - `psutil`: For retrieving system metrics.
   - `tabulate`: For formatting output as tables.

### Install Dependencies

Install the required libraries:
```bash
pip3 install psutil tabulate
```

---

## How to Run

### Step 1: Clone the Repository

Clone the GitHub repository to your local machine:
```bash
git clone https://github.com/<your-username>/mac-system-metrics.git
cd mac-system-metrics
```

### Step 2: Run the Script

Execute the script using Python 3:
```bash
python3 mac_metrics.py
```

---

## Sample Output

```plaintext
===== MAC SYSTEM METRICS =====

=== CPU USAGE ===
Total CPU Usage: 9.3%

=== MEMORY USAGE ===
+------------+---------+
| Metric     | Value   |
+============+=========+
| Total (GB) | 16      |
| Used (GB)  | 10      |
| Free (GB)  | 6       |
| Usage (%)  | 62.5    |
+------------+---------+

=== DISK USAGE ===
+------------+---------+
| Metric     | Value   |
+============+=========+
| Total (GB) | 500     |
| Used (GB)  | 200     |
| Free (GB)  | 300     |
| Usage (%)  | 40.0    |
+------------+---------+

=== SYSTEM INFORMATION ===
+------------------------------+-----------------------------------+
| Metric                       | Value                             |
+==============================+===================================+
| macOS Version                | macOS Sonoma 14.5 (Build 23E79)  |
| Darwin Kernel Version        | 23.5.0                           |
| System                       | Darwin                            |
| Node Name                    | MacBook-Air.local                |
| Uptime                       | 145 days, 2 hrs                  |
| Load Average (1, 5, 15 mins) | (3.65, 3.20, 2.63)               |
+------------------------------+-----------------------------------+
```

---

## Additional Notes

### Tested On:
- macOS Sonoma 14.x
- Should work on other macOS versions with Python 3.x and required libraries.

### Extensibility:
Feel free to extend the script to include additional metrics, such as:
- Network statistics
- Battery health
- Logged-in users

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Contribution

Contributions are welcome! Feel free to fork this repository, create a branch, and submit a pull request for improvements or new features.

---

## Contact

**Dheeraj Bendalam** 

GitHub: [dheerajbenda](https://github.com/dheerajbenda)
