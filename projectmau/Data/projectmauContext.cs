using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using projectmau.Models;

namespace projectmau.Data
{
    public class projectmauContext : DbContext
    {
        public projectmauContext (DbContextOptions<projectmauContext> options)
            : base(options)
        {
        }

        public DbSet<projectmau.Models.Category> Category { get; set; } = default!;

        public DbSet<projectmau.Models.Product>? Product { get; set; }

        public DbSet<projectmau.Models.User>? User { get; set; }
    }
}
