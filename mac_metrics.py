import os
import platform
import psutil
import subprocess
from tabulate import tabulate  # Install using: pip install tabulate

def get_cpu_usage():
    """Get total CPU usage."""
    return f"Total CPU Usage: {psutil.cpu_percent(interval=1)}%"

def get_memory_usage():
    """Get memory usage details."""
    memory = psutil.virtual_memory()
    total = memory.total // (1024 ** 3)  # Convert to GB
    used = memory.used // (1024 ** 3)
    free = memory.available // (1024 ** 3)
    percent = memory.percent
    return {
        "Total (GB)": total,
        "Used (GB)": used,
        "Free (GB)": free,
        "Usage (%)": percent,
    }

def get_disk_usage():
    """Get disk usage details."""
    disk = psutil.disk_usage('/')
    total = disk.total // (1024 ** 3)  # Convert to GB
    used = disk.used // (1024 ** 3)
    free = disk.free // (1024 ** 3)
    percent = disk.percent
    return {
        "Total (GB)": total,
        "Used (GB)": used,
        "Free (GB)": free,
        "Usage (%)": percent,
    }

def get_system_info():
    """Get detailed system information including macOS version and Darwin kernel version."""
    # Fetch macOS version
    try:
        macos_version = subprocess.getoutput("sw_vers | grep 'ProductVersion' | awk '{print $2}'")
        macos_name = subprocess.getoutput("sw_vers | grep 'ProductName' | awk -F':' '{print $2}'").strip()
        macos_build = subprocess.getoutput("sw_vers | grep 'BuildVersion' | awk '{print $2}'")
    except Exception as e:
        macos_version, macos_name, macos_build = "Unknown", "Unknown", "Unknown"

    # Fetch Darwin kernel version
    uname = platform.uname()
    darwin_version = uname.release

    # Fetch uptime
    uptime = subprocess.getoutput("uptime | awk -F',  ' '{print $1}' | sed 's/.*up //g'")

    # Fetch load averages
    load_avg = os.getloadavg()  # Get system load averages

    return {
        "macOS Version": f"{macos_name} {macos_version} (Build {macos_build})",
        "Darwin Kernel Version": darwin_version,
        "System": uname.system,
        "Node Name": uname.node,
        "Release": uname.release,
        "Version": uname.version,
        "Machine": uname.machine,
        "Processor": uname.processor,
        "Uptime": uptime,
        "Load Average (1, 5, 15 mins)": load_avg,
    }

def display_data(data, title):
    """Display data in tabular format."""
    print(f"\n=== {title} ===")
    if isinstance(data, dict):
        print(tabulate(data.items(), headers=["Metric", "Value"], tablefmt="grid"))
    elif isinstance(data, list):
        print(tabulate(data, headers="Values", tablefmt="grid"))
    else:
        print(data)

def main():
    print("===== MAC SYSTEM METRICS =====")
    # CPU Usage
    display_data(get_cpu_usage(), "CPU USAGE")
    # Memory Usage
    display_data(get_memory_usage(), "MEMORY USAGE")
    # Disk Usage
    display_data(get_disk_usage(), "DISK USAGE")
    # System Info
    display_data(get_system_info(), "SYSTEM INFORMATION")

if __name__ == "__main__":
    main()
